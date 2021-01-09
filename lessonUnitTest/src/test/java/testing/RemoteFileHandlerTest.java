package testing;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.*;

import static org.mockito.ArgumentMatchers.any;
import static org.powermock.api.mockito.PowerMockito.verifyPrivate;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
public class RemoteFileHandlerTest {
    @Mock
    SettingsLoader settingsLoader;
    @Mock
    ResponseRepository responseRepository;
    @Mock
    SettingsLoader settingsLoader2;
    @Mock
    ResponseRepository responseRepository2;
    @Mock
    RemoteFileReadWriter remoteFileReadWriter;
    @Mock
    RemoteFileReadWriter rFRW;
    @Mock
    public RemoteFileHandler rFH;
    @Mock
    public RemoteFileHandler rFH2;

    /*handleError*/
    @Test
    public void handleErrorIsNullList() {
        List<String> tmp =null;
        RemoteFileHandler r = new RemoteFileHandler(settingsLoader,responseRepository);
        Assert.assertEquals(false, r.handleError(tmp));
    }

    @Test
    public void handleErrorTrue() {
        List<String> tmp = Arrays.asList("One","Two");
        RemoteFileHandler r = new RemoteFileHandler(settingsLoader,responseRepository);
        Assert.assertEquals(true, r.handleError(tmp));
    }

    @Test(expected = IllegalArgumentException.class)
    public void handleErrorException() {
        List<String> tmp = Arrays.asList("One","error");
        RemoteFileHandler r = new RemoteFileHandler(settingsLoader,responseRepository);
        r.handleError(tmp);
    }

    /*handleRequest*/

    @Test
    public void handleRequestTestTrue() {
        Map<String,String> sett = new HashMap<>();
        ArrayList<String> al = new ArrayList<>();
        sett.put("one","one");
        al.add("Hello");
        RemoteFileHandler r = new RemoteFileHandler(settingsLoader,responseRepository);
        when(settingsLoader.loadSettings()).thenReturn(sett);
        //тут ошибка которая говорит что тест написан неправильно
        when(rFRW.readFileToList(sett)).thenReturn(al);
        r.handleRequest();
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
        RemoteFileHandler r2 = new RemoteFileHandler(settingsLoader2,responseRepository2);
        when(rFH2.validate(any())).thenReturn(b1);
        r2.handleResponse(tmp);
    }

    @Test
    public void handleResponseTestTrueValidate() {
        Boolean b = true;
        List<String> tmp = Arrays.asList("One","error");
        RemoteFileHandler r = new RemoteFileHandler(settingsLoader,responseRepository);
        when(rFH.validate(any())).thenReturn(b);
        when(responseRepository.writeResult(tmp)).thenReturn(b);
        r.handleResponse(tmp);
    }
}