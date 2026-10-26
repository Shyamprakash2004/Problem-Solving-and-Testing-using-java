public class FindTheHighestAltitude {
    public static int largestAltitude(int[] gain) {
        int altitude = 0;
        int highest = 0;

        for (int g : gain) {
            altitude += g;
            highest = Math.max(highest, altitude);
        }

        return highest;
    }

    public static void main(String[] args) {
        int[] gain = {-5, 1, 5, 0, -7};
        System.out.println(largestAltitude(gain));
    }
}
