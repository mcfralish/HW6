import java.util.*;

public class NBATeam {
	
	public class NBAPlayer{
		String name;
		int age;
		
		public NBAPlayer(String name, int age) {
			this.name = name;
			this.age = age;
		}
		
		public String getName() {
			return name;
		}
		
		public int getAge() {
			return age;
		}
	}
	
	private String teamName;
	private ArrayList<NBAPlayer> players;
	
	public NBATeam(String name) {
		teamName = name;
		players = new ArrayList<NBAPlayer>();
	}
	
	public void addAPlayer(String name, int age) {
		players.add(new NBAPlayer(name,age));
	}
	
	public String getTeamName() {
		return teamName;
	}
	
	public int getMaxAge() {
		int max = 0;
		for(int i = 0; i <players.size();i++) {
			if (players.get(i).getAge()>max) {
				max = players.get(i).getAge();				
			}
		}
		return max;
	}
	
	public int getMinAge() {
		int min = Integer.MAX_VALUE;
		for(int i = 0; i <players.size();i++) {
			if (players.get(i).getAge()<min) {
				min = players.get(i).getAge();				
			}
		}
		return min;
	}
	
	public double getAvgAge() {
		int sum = 0;
		for (int i=0;i<players.size();i++) {
			sum += players.get(i).getAge();
		}
		
		double avg = (double)sum/players.size();
		return avg;
	}
	
	public int getNumOfPlayer() {
		return players.size();
	}

}
