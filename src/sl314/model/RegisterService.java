package sl314.model;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

/**
 * This object performs a variety of league registration services.
 * It acts a Facade into the business logic of registering a Player for
 * a League.
 */
public class RegisterService {
    private String dataDirectory;
    
    public RegisterService(String dataDirectory) {
        this.dataDirectory = dataDirectory;
        // do nothing
    }
    
    /**
     * This method finds the specified league, by delegating to the
     * LeagueService object.
     */
    public League getLeague(int year, String season)
    throws ObjectNotFoundException {
        LeagueService leagueSvc = new LeagueService(dataDirectory);
        return leagueSvc.getLeague(year, season);
    }
    
    /**
     * This method return a Player object for the named person, by
     * delegating to the PlayerService object.
     */
    public Player getPlayer(String name) {
        PlayerService playerSvc = new PlayerService(dataDirectory);
        return playerSvc.getPlayer(name);
    }
    
    /**
     * This method stores the registration information for the player,
     * based on the league and division information.
     */
    public void register(League league, Player player, String division) {
        
        // Use the player service to save the player object
        PlayerService playerSvc = new PlayerService(dataDirectory);
        playerSvc.save(player);
        
        // Record the registration
        insertRegistration(league, player, division);
    }
    
    private void insertRegistration(League league, Player player,
            String division) {
        
        // Store the registration info to a data file
        String regFile = dataDirectory + "registrations.txt";
        PrintWriter regWriter = null;
        try {
            // Open a writer stream and mark it to append the new data
            regWriter = new PrintWriter(new FileWriter(regFile, true));
            
            regWriter.print(league.objectID);
            regWriter.print('\t');
            regWriter.print(player.name);
            regWriter.print('\t');
            regWriter.print(division );
            regWriter.println();
            
        } catch (Exception e) {
            throw new RuntimeException(e);
            
            // Clean up IO resources
        } finally {
            if ( regWriter != null ) {
                try { regWriter.close(); } catch (Exception e) { System.err.println(e); }
            }
        }
    } // END of insertRegistration method
    
} // END of RegisterService class
