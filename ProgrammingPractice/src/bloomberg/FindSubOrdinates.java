package bloomberg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindSubOrdinates {
	
	public static void main(String[] args) {
        Map<Integer,List<Integer>> empMap = new HashMap<>();
        empMap.put(1, Arrays.asList(2,3,4));
        empMap.put(3, Arrays.asList(5,6,7));
        empMap.put(5, Arrays.asList(8,9,10));
        empMap.put(9, Arrays.asList(11,12,13));
        
        FindSubOrdinates o = new FindSubOrdinates();
        System.out.println(o.getReportees(empMap,3));
    }

    public List<Integer> getReportees(Map<Integer,List<Integer>> empMap,int manager){
        List<Integer> result = new ArrayList<>();
        getReporteesHelper(result,empMap,manager);
        return result;
    }

    private void getReporteesHelper(List<Integer> result, Map<Integer, List<Integer>> empMap, Integer manager) {
        List<Integer> reportees = empMap.get(manager);
        if(reportees==null)
            return;
        for (Integer i: reportees) {
            result.add(i);
            getReporteesHelper(result,empMap,i);
        }
    }
}
