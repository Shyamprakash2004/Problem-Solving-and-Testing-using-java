import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {
    class CheckInInfo {
        String stationName;
        int time;
        public CheckInInfo(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }
    
    class RouteStats {
        double totalTime;
        int count;
        public RouteStats() {
            this.totalTime = 0;
            this.count = 0;
        }
    }

    private Map<Integer, CheckInInfo> checkIns;
    private Map<String, RouteStats> journeyStats;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        journeyStats = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckInInfo(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        CheckInInfo info = checkIns.remove(id);
        String route = info.stationName + "->" + stationName;
        int timeTaken = t - info.time;
        
        journeyStats.putIfAbsent(route, new RouteStats());
        RouteStats stats = journeyStats.get(route);
        stats.totalTime += timeTaken;
        stats.count++;
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "->" + endStation;
        RouteStats stats = journeyStats.get(route);
        return stats.totalTime / stats.count;
    }
}
