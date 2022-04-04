import java.util.HashMap;
import java.util.Set;

public class TestHashMap {
    public static void main(String[] args){
        HashMap<String, String> trackList = new HashMap<String, String>();

        trackList.put("Polyamorous","The day has come to an end The sun is over my head My polyamorous friend She got me in a mess of trouble again");
        trackList.put("The Diary of Jane","If I had to I would put myself right beside you So let me ask, would you like that? Would you like that? And I don't mind If you say this love is the last time So now I'll ask, do you like that? Do you like that? No!")  ;
        trackList.put("I Will Not Bow","Now the dark begins to rise Save your breath, it's far from over Leave the lost and dead behind Now's your chance to run for cover");
        trackList.put("Already Over","You never go You're always here (suffocating me) Under my skin I cannot run away Fading slowly");
        
        System.out.println(trackList.get("Polyamorous"));
        System.out.println();

        Set<String> keys = trackList.keySet();

        for(String key : keys) {
            System.out.println(key + " : " + trackList.get(key));
            System.out.println();
        }

    }
}
