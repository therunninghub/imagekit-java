package io.imagekit.sdk.models;

import io.imagekit.sdk.utils.Utils;
import io.imagekit.sdk.utils.UtilsTest;
import org.junit.Test;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class FileCreateRequestTest {
    @Test
    public void fileFromURL_constructor_test() throws Exception {
        URL url = URI.create("https://sample-videos.com/img/Sample-jpg-image-50kb.jpg").toURL();
        FileCreateRequest SUT = new FileCreateRequest(url, "file_name");
        assertNotNull(SUT);
    }

    @Test
    public void base64_constructor_test() {
        URL imageURL = UtilsTest.class.getClassLoader().getResource("sample1.jpg");
        File file = new File(imageURL.getPath());
        String base64 = Utils.fileToBase64(file);
        FileCreateRequest SUT = new FileCreateRequest(base64, "file_name");
        assertNotNull(SUT);
    }

    @Test
    public void bytes_constructor_test() {
        URL imageURL = UtilsTest.class.getClassLoader().getResource("sample1.jpg");
        File file = new File(imageURL.getPath());
        byte[] bytes = Utils.fileToBytes(file);
        FileCreateRequest SUT = new FileCreateRequest(bytes, "file_name");
        assertNotNull(SUT);
    }

    @Test
    public void test_getter_setter() {
        URL imageURL = UtilsTest.class.getClassLoader().getResource("sample1.jpg");
        File file = new File(imageURL.getPath());
        String base64 = Utils.fileToBase64(file);
        FileCreateRequest SUT = new FileCreateRequest(base64, "file_name");

        List<String> tags = mock(List.class);
        List<String> responseFields = mock(List.class);

        SUT.setCustomCoordinates("0,0,10,20");
        SUT.setFileName("file_name");
        SUT.setFolder("dir1");
        SUT.setPrivateFile(true);
        SUT.setResponseFields(responseFields);
        SUT.setTags(tags);
        SUT.setUseUniqueFileName(true);

        assertEquals("0,0,10,20", SUT.getCustomCoordinates());
        assertEquals("file_name", SUT.getFileName());
        assertEquals("dir1", SUT.getFolder());
        assertTrue(SUT.isPrivateFile());
        assertEquals(responseFields, SUT.getResponseFields());
        assertEquals(tags, SUT.getTags());
        assertTrue(SUT.isUseUniqueFileName());

    }
//
//    @Test
//    public void test_prepareRequest() {
//        URL imageURL = UtilsTest.class.getClassLoader().getResource("sample1.jpg");
//        File file=new File(imageURL.getPath());
//        String base64 = Utils.fileToBase64(file);
//        FileCreateRequest SUT=new FileCreateRequest(base64,"file_name");
//        assertNotNull(SUT.prepareRequest());
//    }
//
//    @Test(expected = RuntimeException.class)
//    public void test_prepareRequest_with_null_url_expectException() {
//        URL url=null;
//        FileCreateRequest SUT=new FileCreateRequest(url,"file_name");
////        assertNotNull(SUT.prepareRequest());
//    }
//
//    @Test(expected = RuntimeException.class)
//    public void test_prepareRequest_with_null_file_name_expectException() throws Exception{
//        URL url=new URL("http","localhost",3000,"/demo.jpg");
//        FileCreateRequest SUT=new FileCreateRequest(url,null);
//        assertNotNull(SUT.prepareRequest());
//    }
}
