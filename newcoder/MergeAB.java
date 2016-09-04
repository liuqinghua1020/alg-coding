
public class MergeAB {
	
	public int[] mergeAB(int[] A, int[] B, int n, int m) {
 
		int lastIndex = A.length - 1;
		int i=n-1,j=m-1;
		
		while(i>=0 && j >= 0){
			   if(A[i]<B[j]){
				    A[lastIndex--] = B[j--];
			   }else{
				   A[lastIndex--] = A[i--];
			   }
		}
		
		while(i>=0){
			 A[lastIndex--] = A[i--];
		}
		
		while(j>=0){
			 A[lastIndex--] = B[j--];
		}
		
		return A;
	}
	
	public static void main(String[] args) {
		int[] A = {17413,26696,27419,36377,56415,135953,142208,148191,162935,223175,227457,232547,270061,293536,300646,323370,337601,343498,349062,361535,362542,363281,372346,399285,424290,424891,430823,431146,433225,459024,500673,501109,501915,507799,514223,514646,520564,525483,534100,539424,575651,580326,581038,585391,588557,595756,601421,643763,647735,669766,669941,671404,680057,680320,687351,711669,718681,741883,749333,759829,760008,766856,782114,782759,802341,804566,822965,823452,847246,879368,896815,902133,911041,919142,936836,943065,982593,988176,1015524,1028627,1044204,1056030,1056085,1056621,1071172,1089708,1097150,1113894,1115006,1118614,1134721,1151263,1178253,1186313,1233056,1251125,1256203,1273615,1275792,1285086,1302333,1306432,1315697,1316031,1337393,1344430,1361173,1379606,1389331,1425968,1427969,1493366,1505506,1514123,1522673,1535749,1544169,1548120,1594948,1607054,1636661,1639341,1671379,1678150,1686198,1691751,1716858,1720848,1752631,1766501,1768226,1769213,1778554,1807015,1820754,1861536,1867697,1870014,1884344,1890660,1896179,1905934,1908704,1922214,1941840,1945809,1962979,1973065,1974845,1985003,2021128,2023622,2025876,2026541,2035920,2065297,2076795,2094946,2107890,2112889,2126179,2126583,2137330,2151196,2154303,2164515,2183856,2204159,2212169,2225243,2234135,2280538,2287812,2304762,2313600,2321748,2347696,2360344,2400864,2436301,2450937,2500668,2516372,2521740,2530812,2553004,2553785,2556379,2571247,2579918,2587981,2593730,2599151,2603585,2611102,2659102,2664495,2683060,2685404,2714644,2720820,2745828,2756244,2768818,2775545,2776592,2794928,2813026,2813345,2818735,2821910,2853850,2857249,2867847,2875605,2907800,2908297,2940285,2942283,2972829,2976380,2986013,2989534,3015162,3025684,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		int[] B = {15181,20937,34523,53329,83373,94526,112629,115543,194613,208478,265297,268974,292027,332294,363837,367196,385237,393630,408551,413216,433405,443321,464497,474039,540533,542456,548033,576284,595360,596912,623229,639268,651070,653427,666818,670894,677075,692155,706595,718743,722856,737892,751281,764934,798768,844048,865715,891280,897575,1033825,1037001,1099612,1111165,1116091,1129796,1133689,1144898,1182392,1183875,1190226,1221605,1227491,1228354,1244608,1249157,1267412,1290421,1298684,1327266,1337872,1364796,1394502,1405391,1471004,1472387,1478425,1514465,1527415,1589733,1635671,1647384,1657642,1658417,1686492,1699286,1739686,1744389,1785707,1799269,1799777,1803987,1848646,1858803,1863169,1887748,1931474,1974413,1994991,2053465,2054247,2060481,2064016,2084626,2094003,2100807,2102395,2179141,2195223,2196483,2217236,2238453,2274229,2295144,2317835,2355472,2362980,2367366,2417076,2466653,2487378,2512416,2530752,2558439,2578555,2584074,2632927,2642426,2671865,2671913,2676075,2680872,2691884,2699411,2702655,2707867,2728772,2741442,2755202,2770399,2810875,2812537,2888485,2890613,2898710,2911540,2920980,2954424,2955485,2978795,2984864,2988301,2989000,2989421,3017261};
		int n = 225;
		int m = 154;
		MergeAB ab = new MergeAB();
		int[] C = ab.mergeAB(A, B, n, m);
		/*for(int c:C){
			System.out.print(" " + c + " ");
		}*/
		System.out.println(C.length);
	}

}
