import java.io.*;
import java.util.*;
class bloomon{
    public static class Bouquet{
        Map<Character,Integer> flowers;
        String spec;
        char size;
        int extraFLowers;
        int sumOfFlowers;
        Bouquet(String spec){
            this.spec = spec;
            flowers = new HashMap<Character,Integer>();
            size = spec.charAt(1);
            sumOfFlowers = 0;
            for(int i=2;i<spec.length();i++){
                StringBuilder sb = new StringBuilder();
                while(i<spec.length()&&spec.charAt(i)>=48 && spec.charAt(i)<=57)
                    sb.append(spec.charAt(i++));
                if(i!=spec.length()){
                    flowers.put(spec.charAt(i),Integer.parseInt(sb.toString()));
                    sumOfFlowers+=Integer.parseInt(sb.toString());
                }
                else
                    extraFLowers = Integer.parseInt(sb.toString())-sumOfFlowers;
            }
        }

    }
    public static void main(String[] ss)throws Exception{
        List<Bouquet> bouquets = new ArrayList<Bouquet>();
        
        Map<Character,int[]> flowers = new HashMap<>();
        flowers.put('S',new int[26]);
        flowers.put('L',new int[26]);
        int totalLargeFLowers = 0;
        int totalSmallFLowers = 0;

        BufferedReader br=new BufferedReader(new FileReader("../sample/input.txt"));
        String line = "";
        while(!(line = br.readLine()).equals("")){
            bouquets.add(new Bouquet(line));
        }

        int num =8;
        while((line = br.readLine())!=null){
            num++;
            char size = line.charAt(1);
            char flowerType = line.charAt(0);
            int temp[] = flowers.get(size);
            temp[flowerType-'a']++;
            int TEMP_flowerCount =0;
            if(size =='S'){
                totalSmallFLowers++;
                TEMP_flowerCount = totalSmallFLowers;
            }
            else{
                totalLargeFLowers++;
                TEMP_flowerCount = totalLargeFLowers;
            }
            for(Bouquet bouquet : bouquets){
                if(bouquet.size==size){
                    boolean flag = true;
                    for(Map.Entry<Character,Integer> e: bouquet.flowers.entrySet()){
                        if(temp[e.getKey()-'a']<e.getValue()){
                            flag = false;
                            break;
                        }
                    }
                    if(flag && TEMP_flowerCount>=bouquet.sumOfFlowers+bouquet.extraFLowers){
                        if(size=='S')
                            totalSmallFLowers-=bouquet.sumOfFlowers+bouquet.extraFLowers;
                        else
                            totalLargeFLowers-=bouquet.sumOfFlowers+bouquet.extraFLowers;
                        
                        for(Map.Entry<Character,Integer> e: bouquet.flowers.entrySet()){
                            temp[e.getKey()-'a']-=e.getValue();
                        }
                        while(bouquet.extraFLowers>0){
                            for(int i = 0;i<26;i++){
                                if(bouquet.extraFLowers>=temp[i]){
                                    bouquet.extraFLowers-=temp[i];
                                    temp[i]=0;
                                }
                                else{
                                    temp[i]-=bouquet.extraFLowers;
                                    bouquet.extraFLowers=0;
                                }
                            }
                            
                        }
                        //System.out.println(bouquet.spec);
                        System.out.println(bouquet.spec+" "+num+" "+line);
                        bouquets.remove(bouquet);
                        break;
                    }
                }
            } 
            if((totalLargeFLowers+totalSmallFLowers)==256){
                // for(Map.Entry<Character,int[]> e: flowers.entrySet()){
                //     for(int i=0;i<26;i++){
                //         char c= (char)(97+i);
                //         System.out.print(c+" =" +e.getValue()[i]+"     ");
                //     }
                //     System.out.println();
                // }
                System.out.println("No more flowers can be processed. Exiting....."+num+" "+line);
                System.exit(0);
            } 
        }
    }
}