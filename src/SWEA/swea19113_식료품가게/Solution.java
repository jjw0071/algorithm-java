package SWEA.swea19113_식료품가게;

import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    public static void main(String args[]) throws Exception
    {
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
        //System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int test_case = 1; test_case <= T; test_case++)
        {
            bw.append("#"+test_case+" ");
            st = new StringTokenizer(br.readLine());
            int itemCount = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            PriorityQueue<Long> items = new PriorityQueue<>();
            PriorityQueue<Long> disItems = new PriorityQueue<>();
            for(int itemNum = 0 ; itemNum<2*itemCount;itemNum++){
                long item = Long.parseLong(st.nextToken());
                items.add(item);
            }

            for(int i = 0 ; i < items.size();i++){
                long item = items.poll();
                if(items.contains(item*4/3)){
                    disItems.add(item);
                    items.remove(item*4/3);
                    i--;
                }
            }

            for(long item: disItems){
                bw.append(item+" ");
            }
            bw.append("\n");
        }
        bw.flush();
        bw.close();
    }
}