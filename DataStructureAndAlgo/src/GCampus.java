import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class GCampus {

    private static HashMap<Integer, List<Integer>> left_map_rights;

    public List<List<Integer>> GetAllRoutes(Integer start, Integer end) {
        List<List<Integer>> routes = new ArrayList<>();
        List<Integer> rights = left_map_rights.get(start);
        if (rights != null) {
            for (Integer right : rights) {
                List<Integer> route = new ArrayList<>();
                route.add(start);
                route.add(right);
                Chain(routes, route, right, end);
            }
        }
        return routes;
    }

    public void Chain(List<List<Integer>> routes, List<Integer> route, Integer right_most_currently, Integer end) {
        if (right_most_currently.equals(end)) {
            routes.add(route);
            return;
        }
        List<Integer> rights = left_map_rights.get(right_most_currently);
        if (rights != null) {
            for (Integer right : rights) {
                if (!route.contains(right)) {
                    List<Integer> new_route = new ArrayList<Integer>(route);
                    new_route.add(right);
                    Chain(routes, new_route, right, end);
                }
            }
        }
    }
	
	
	public GCampus() throws Exception {
		/*BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("A-small-attempt0.in")));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("A-small-attempt0.out")));*/
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(in.readLine());
		int caseno = 0;
		while(T-- > 0) {
			String input[] = in.readLine().trim().split(" ");

			int N = Integer.parseInt(input[0]);
			int M = Integer.parseInt(input[1]);
			caseno++;
			out.write("Case #"+caseno+":\n");
			while(M-- > 0) {
				input = in.readLine().trim().split(" ");
				int U = Integer.parseInt(input[0]);
				int V = Integer.parseInt(input[1]);
				int C = Integer.parseInt(input[1]);
				
				left_map_rights = new HashMap<>();
		            List<Integer> rights = left_map_rights.get(U);
		            if (rights == null) {
		                rights = new ArrayList<Integer>();
		                left_map_rights.put(U, rights);
		            }
		            rights.add(V);
		            
		        ///System.out.println("start");
		        List<List<Integer>> routes = GetAllRoutes(1, 2);
		        //System.out.println("end");
		        for (List<Integer> route : routes) {
		            System.out.println(" : " +route);
		        }
				
				//out.write(edge+ "\n");
			}
		}
		out.flush();	
		
	}
	
	public static void main(String args[]) throws Exception {
		new GCampus();
	}
}
