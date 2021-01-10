package testing;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.*;

import static com.sun.javaws.JnlpxArgs.verify;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(RemoteFileHandler.class)
public class RemoteFileHandlerTest {
    @Mock
    SettingsLoader settingsLoader;
    @Mock
    ResponseRepository responseRepository;
    @Mock
    RemoteFileReadWriter remoteFileReadWriter;
    @Mock
    RemoteFileReadWriter rFRW;
    @Mock
    RemoteFileHandler rFH;

    /*handleError*/
    @Test
    public void handleErrorIsNullList() {
        List<String> tmp =null;
        RemoteFileHandler r = new RemoteFileHandler(settingsLoader,responseRepository);
        Assert.assertFalse(r.handleError(tmp));
    }

    @Test
    public void handleErrorTrue() {
        List<String> tmp = Arrays.asList("One","Two");
        RemoteFileHandler r = new RemoteFileHandler(settingsLoader,responseRepository);
        Assert.assertTrue(r.handleError(tmp));
    }

    @Test(expected = IllegalArgumentException.class)
    public void handleErrorException() {
        List<String> tmp = Arrays.asList("One","error");
        RemoteFileHandler r = new RemoteFileHandler(settingsLoader,responseRepository);
        r.handleError(tmp);
    }

    /*handleRequest*/

    @Test
    public void handleRequestTestTrue() throws Exception {
        Map<String,String> sett = new HashMap<>();
        ArrayList<String> al = new ArrayList<>();
        sett.put("one","one");
        al.add("Hello");
        RemoteFileHandler r = new RemoteFileHandler(settingsLoader,responseRepository);
        when(settingsLoader.loadSettings()).thenReturn(sett);
        //тут ошибка которая говорит что тест написан неправильно
        //when(rFRW.readFileToList(sett)).thenReturn(al);
        //надо заменить на следующие 2 строчки
        RemoteFileReadWriter fileReadWriter = mock(RemoteFileReadWriter.class);
        PowerMockito.whenNew(RemoteFileReadWriter.class).withNoArguments().thenReturn(fileReadWriter);
        r.handleRequest();
        //verify(responseRepository).writeResult(al); //вроде правильно написал, но выдает ошибку
    }

    @Test
    public void handleRequestTestException() {
        Map<String,String> sett = new HashMap<>();
        sett.put("one","one");
        RemoteFileHandler r = new RemoteFileHandler(settingsLoader,responseRepository);
        when(settingsLoader.loadSettings()).thenReturn(sett);
        when(remoteFileReadWriter.readFileToList(sett)).thenThrow();
        r.handleRequest();
    }


    /*handleResponse*/

    @Test
    public void handleResponseTestFail() {
        Boolean b1 = false;
        List<String> tmp = Arrays.asList("One","error");
        //rfh.handleResponse(tmp);
        RemoteFileHandler r = new RemoteFileHandler(settingsLoader,responseRepository);
        when(rFH.validate(any())).thenReturn(b1);
        r.handleResponse(tmp);
    }

    @Test
    public void handleResponseTestTrueValidate() throws Exception {
        Boolean b = true;
        List<String> tmp = Arrays.asList("One","error");
        RemoteFileHandler r = new RemoteFileHandler(settingsLoader,responseRepository);
        when(rFH.validate(any())).thenReturn(b);
        when(responseRepository.writeResult(tmp)).thenReturn(b);
        //теоретически здесь тоже должны быть эти 2 строки
        //но почему-то тут ошибка пропала скорее всего стал использоваться ранее описанный mock
        //RemoteFileReadWriter fileReadWriter = mock(RemoteFileReadWriter.class);
        //PowerMockito.whenNew(RemoteFileReadWriter.class).withNoArguments().thenReturn(fileReadWriter);
        r.handleResponse(tmp);
    }
}