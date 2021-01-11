package testing;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Incubating;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.*;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({RemoteFileHandler.class})
public class RemoteFileHandlerTest {
    @Mock
    SettingsLoader settingsLoader;
    @Mock
    ResponseRepository responseRepository;
    @Mock
    RemoteFileReadWriter rFRW;
    @InjectMocks
    RemoteFileHandler rFH;

    /*handleError*/
    @Test
    public void handleErrorIsNullList() {
        //RemoteFileHandler r = new RemoteFileHandler(settingsLoader,responseRepository);
        Assert.assertFalse(rFH.handleError(null));
        Assert.assertFalse(rFH.handleError(Collections.emptyList()));
    }

    @Test
    public void handleErrorTrue() {
        //RemoteFileHandler r = new RemoteFileHandler(settingsLoader,responseRepository);
        List<String> tmp = Arrays.asList("One","Two");
        Assert.assertTrue(rFH.handleError(tmp));
    }

    @Test(expected = IllegalArgumentException.class)
    public void handleErrorException() {
        //RemoteFileHandler r = new RemoteFileHandler(settingsLoader,responseRepository);
        List<String> tmp = Arrays.asList("One","error");
        rFH.handleError(tmp);
    }

    /*handleRequest*/
    @Test
    public void handleRequestTestTrue() throws Exception {
        Map<String,String> sett = new HashMap<>();
        sett.put("one","one");
        when(settingsLoader.loadSettings()).thenReturn(sett);
        //везде подменяем объект на InjectMocks rFH(кроме шпиона)
        //RemoteFileHandler r = new RemoteFileHandler(settingsLoader,responseRepository);
        //тут ошибка которая говорит что тест написан неправильно
        //потому что вызывали на реальном объекте, а не на моске
        //when(rFRW.readFileToList(sett)).thenReturn(al);
        //надо заменить на следующие 2 строчки (создаем mock вместо создаваемого объекта)
        RemoteFileReadWriter fileReadWriter = mock(RemoteFileReadWriter.class);
        PowerMockito.whenNew(RemoteFileReadWriter.class).withNoArguments().thenReturn(fileReadWriter);
        //можно было заменить 2 верхние строчки на одну снизу
        //PowerMockito.whenNew(RemoteFileReadWriter.class).withNoArguments().thenReturn(rFRW);
        rFH.handleRequest();
        verify(responseRepository).writeResult(any());
    }

    @Test
    public void handleRequestTestException() {
        RemoteFileHandler r = new RemoteFileHandler(settingsLoader,responseRepository);
        when(settingsLoader.loadSettings()).thenThrow(new ArithmeticException("qwertyui"));
        r.handleRequest();
        verify(responseRepository).writeError(contains("qwe"));
    }


   /*handleResponse*/
   //из-за приватного метода необходимо использовать spy
    @Test
    public void handleResponseTestFail() {
        List<String> tmp = Arrays.asList("One","error");
        RemoteFileHandler r = spy(new RemoteFileHandler(settingsLoader,responseRepository));
        try {
            PowerMockito.when(r,"validate",anyList()).thenReturn(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        r.handleResponse(tmp);
        verify(responseRepository).writeError(anyString());
    }

    @Test
    public void handleResponseTestTrueValidate() throws Exception {
        Boolean b = true;
        List<String> tmp = Arrays.asList("One","error");
        RemoteFileHandler r =spy(new RemoteFileHandler(settingsLoader,responseRepository));
        PowerMockito.when(r,"validate",anyList()).thenReturn(b);
        //2 строки сверху позволили получить результат приватного метода validate
        //который ниже выдавал ошибку
        //when(rFH.validate(any())).thenReturn(b);
        when(responseRepository.writeResult(tmp)).thenReturn(b);
        PowerMockito.whenNew(RemoteFileReadWriter.class).withNoArguments().thenReturn(rFRW);
        r.handleResponse(tmp);
        verify(responseRepository).writeResult(tmp);
        verify(rFRW).writeResponse();
    }
}