package com.anshishagua;

import com.anshishagua.utils.YamlUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.yaml.snakeyaml.Yaml;

import java.util.Arrays;

public class YamlUtilsTest {
    private Object object;

    @Before
    public void load() {
        Yaml yaml = new Yaml();

        object = yaml.load(YamlUtils.class.getClassLoader().getResourceAsStream("test.yaml"));
    }

    @Test
    public void testGetAsString() {
        Assert.assertEquals(YamlUtils.getAsString(object, "join_end.wait[0]", null), "switch_send_message");
//        Assert.assertEquals(YamlUtils.getAsString(object, "aaa[0][0]", null), "bbb");
    }

    @Test
    public void testGetAsInteger() {
        Assert.assertEquals((int) YamlUtils.getAsInteger(object, "person.id", null), 11);
    }

    @Test
    public void testGetAsBoolean() {
        Assert.assertEquals(YamlUtils.getAsBoolean(object, "mkt_meta_data.alert_on_fail", null), true);
    }

    @Test
    public void testGetAsDouble() {
        Assert.assertEquals(YamlUtils.getAsDouble(object, "value1", null), 3.435, 0.001);
    }

    @Test
    public void testGetAsList() {
        Assert.assertEquals(YamlUtils.getAsList(object, "start.next", null), Arrays.asList("wait_android_app_event", "wait_ios_app_event"));
    }
}