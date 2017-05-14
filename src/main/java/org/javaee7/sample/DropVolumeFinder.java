package org.javaee7.sample;

import lombok.Data;

import javax.ejb.Stateless;
import java.util.*;

/**
 * Created by timeking on 13.05.17.
 */
@Stateless
public class DropVolumeFinder {

    /**
     * Finds volume of water which remains after the rain on pointed relief
     *
     * @param relief - description of highs of relief
     * @return volume of water in relief
     */
    public int findDropVolume(List<Integer> relief) {
        if (relief == null || relief.size() < 3) {
            return 0;
        }

        Max max = findMax(relief);
        int volume = 0;
        if (max.getIndex() < relief.size() - 1) {
            volume += findRightVolume(relief.subList(max.getIndex() + 1, relief.size()));
        }
        if (max.getIndex() > 1) {
            List<Integer> leftSubRelief = new ArrayList<>(relief.subList(0, max.getIndex()));
            Collections.reverse(leftSubRelief);
            volume += findRightVolume(leftSubRelief);
        }
        return volume;
    }

    private int findRightVolume(List<Integer> subRelief) {
        Max rightMax = findMax(subRelief);
        int volume = 0;
        for (int i = 0; i < rightMax.getIndex(); i++) {
            volume += rightMax.getValue() - subRelief.get(i);
        }
        if (rightMax.getIndex() < subRelief.size() - 1) {
            volume += findRightVolume(subRelief.subList(rightMax.getIndex() + 1, subRelief.size()));
        }

        return volume;
    }


    @Data
    private static class Max {
        final int index;
        final int value;
    }

    private static Max findMax(List<Integer> list) {
        int max = list.get(0);
        int maxIndex = 0;
        for (int i = 0; i < list.size(); i++) {
            Integer currentElement = list.get(i);
            if (currentElement > max) {
                max = currentElement;
                maxIndex = i;
            }
        }
        return new Max(maxIndex, max);
    }

}
