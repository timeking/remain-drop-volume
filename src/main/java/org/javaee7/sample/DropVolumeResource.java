package org.javaee7.sample;

import org.apache.commons.lang3.StringUtils;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by timeking on 14.05.17.
 */
@Path("/volume")
public class DropVolumeResource {
    @Inject
    private DropVolumeFinder dropVolumeFinder;

    @POST
    @Path("/")
    @Produces("application/json")
    public Integer calcVolume(@FormParam("relief") String relief) {
        if (StringUtils.isBlank(relief)) {
            throw new IllegalArgumentException("Relief should be non blank");
        }
        try {
            List<Integer> integerRelief = Arrays.stream(relief.split(" "))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
            return dropVolumeFinder.findDropVolume(integerRelief);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Relief should be integer array");
        }
    }


}
