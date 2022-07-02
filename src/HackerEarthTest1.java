import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
class HackerEarthTest1 {
    public static void main(String args[] ) throws Exception {
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        Integer N = Integer.parseInt(name);
        List<List<Integer>> dataOfNode = new ArrayList<>();
        for(int i=0;i<N;i++){
            String lineOfData = br.readLine();
            List<Integer> oneNode = Stream.of(lineOfData.split(" ")).map(Integer::valueOf).collect(Collectors.toList());
            dataOfNode.add(oneNode);
        }

        //result store into
        Map<Integer,List<Integer>> resultMap = new HashMap<>();

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(i!=j){
                    if(checkIfSubset(dataOfNode.get(i), dataOfNode.get(j))){
                        if(resultMap.containsKey(j)){
                            List<Integer> temp =resultMap.get(j);
                            //System.out.println(temp);
                            temp.add(Integer.valueOf(i));
                        } else {
                            List<Integer> toAddList = new ArrayList<>();
                            toAddList.add(i);
                            resultMap.put(j, toAddList);
                        }
                    }
                }
            }
        }

        //System.out.println(resultMap);

        //creating the graph
        reduceTheResultMap(resultMap);

        printOutput(resultMap, N);
        
        // System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
    }

    private static void printOutput(Map<Integer, List<Integer>> resultMap, int N) {
        for(int i=0;i<N;i++){
            if(resultMap.containsKey(i)){
                System.out.println(resultMap.get(i).stream().sorted(Collections.reverseOrder()).map(Object::toString).collect(Collectors.joining(" ")));
            } else {
                System.out.println("-1");
            }
        }
    }

    static boolean checkIfSubset(List<Integer> parent, List<Integer> child){
        boolean flag = true;
        for(Integer i:child){
            if(!parent.contains(i)){
                flag = false;
            }
        }
        return flag;
    }

    static void reduceTheResultMap(Map<Integer,List<Integer>> resultMap){
        for(Map.Entry<Integer, List<Integer>> entry:resultMap.entrySet()){
            for(int k:entry.getValue()){
                // if(resultMap.containsKey(k)){
                //     List<Integer> removeFromValue = resultMap.get(k);
                //     // entry.getValue().removeAll(removeFromValue);
                //     List<Integer> modifiedList = entry.getValue().stream().filter(e -> !removeFromValue.contains(e)).collect(Collectors.toList());
                //     entry.setValue(modifiedList);
                    
                    
                // }
                removeValue(resultMap,entry,k);
            }
        }

        //System.out.println(resultMap);
    }

    private static void removeValue(Map<Integer,List<Integer>> resultMap, Map.Entry<Integer, List<Integer>> entry, int k){
        if(resultMap.containsKey(k)){
            List<Integer> removeFromValue = resultMap.get(k);
            // entry.getValue().removeAll(removeFromValue);
            List<Integer> modifiedList = entry.getValue().stream().filter(e -> !removeFromValue.contains(e)).collect(Collectors.toList());
            entry.setValue(modifiedList);
            
            for(int z:removeFromValue){
                removeValue(resultMap,entry,z);
            }
        }
        

    }

}
