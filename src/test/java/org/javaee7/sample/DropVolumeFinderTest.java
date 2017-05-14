package org.javaee7.sample;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by timeking on 14.05.17.
 */
public class DropVolumeFinderTest {
    private DropVolumeFinder dropVolumeFinder;

    @Before
    public void setUp() throws Exception {
        dropVolumeFinder = new DropVolumeFinder();
    }

    @Test
    public void findDropVolume() throws Exception {
        Assert.assertEquals(
                2,
                dropVolumeFinder.findDropVolume(Arrays.asList(3, 2, 4, 1, 2))
        );
        Assert.assertEquals(
                8,
                dropVolumeFinder.findDropVolume(Arrays.asList(4, 1, 1, 0, 2, 3))
        );
        Assert.assertEquals(
                8,
                dropVolumeFinder.findDropVolume(Arrays.asList(3, 2, 0, 1, 1, 4))
        );
        Assert.assertEquals(
                3,
                dropVolumeFinder.findDropVolume(Arrays.asList(4, 4, 2, 5, 4, 3, 4))
        );
        Assert.assertEquals(
                0,
                dropVolumeFinder.findDropVolume(Arrays.asList(2, 3, 4, 5, 4, 3, 2))
        );
        Assert.assertEquals(
                0,
                dropVolumeFinder.findDropVolume(Collections.emptyList())
        );
    }

}