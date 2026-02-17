package org.tasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoyerMooreHorspool {
    private Map<Character, Integer> buildShiftTable(String pattern) {
        int patternLength = pattern.length();
        Map<Character, Integer> shiftTable = new HashMap<>();

        for (int i = 0; i < patternLength - 1; i++) {
            char currentCharacter = pattern.charAt(i);
            int shiftDistance = patternLength - 1 - i;

            shiftTable.put(currentCharacter, shiftDistance);
        }

        return shiftTable;
    }

    private int searchPatternComparison( int windowStartIndex, int patternLength, String fullText, String patternToSearch){
        int patternComparisonIndex = patternLength - 1;
        while (patternComparisonIndex >= 0 &&
                fullText.charAt(windowStartIndex + patternComparisonIndex) == patternToSearch.charAt(patternComparisonIndex)) {

            patternComparisonIndex--;
        }
        return patternComparisonIndex;
    }

    public List<Integer> searchWithBoyerMooreHorspool(String fullText, String patternToSearch ) {

        Map<Character, Integer> shiftTable = buildShiftTable(patternToSearch);
        List<Integer> matchPositions = new ArrayList<>();
        int textLength = fullText.length();
        int patternLength = patternToSearch.length();

        if (patternLength == 0 || patternLength > textLength) {
            return matchPositions;
        }

        int windowStartIndex = 0;

        while (windowStartIndex <= textLength - patternLength) {

            int patternComparisonIndex = searchPatternComparison(windowStartIndex, patternLength, fullText, patternToSearch);

            if (patternComparisonIndex < 0) {
                matchPositions.add(windowStartIndex);
            }

            char characterAlignedWithPatternEnd = fullText.charAt(windowStartIndex + patternLength - 1);
            int shiftDistance = shiftTable.getOrDefault(characterAlignedWithPatternEnd, patternLength);
            windowStartIndex += shiftDistance;
        }

        return matchPositions;
    }
}
