package sl314.model;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

/**
 * This object performs a variety of player services, such as looking
 * up player objects and creating new ones.
 *
 * Note: This implementation uses flat-files to maintain player records.
 * This is inefficient and has several bugs.  A better data persistence
 * mechanism is to use a database.  See the code examples in the database
 * module.
 */
public class PlayerService {
    private String dataDirectory;
    
    public PlayerService(String dataDirectory) {
        this.dataDirectory = dataDirectory;
    }
    
    /**
     * This method finds the specified Player object from the
     * complete set of players.
     */
    public Player getPlayer(String name) {
        
        Player player = readPlayer(name);
        
        if ( player == null ) {
            player = new Player(name);
        }
        
        return player;
    }
    
    /**
     * This method adds a new Player object.
     */
    public void save(Player player) {
        // Store the player.
        storePlayer(player);
        // This is a poor design because it will allow duplicate player
        // records in the data file.
    }
    
    
    /**
     * This private method retrieves a single player from the data file.
     */
    private Player readPlayer(String search_name) {
        File playerFile = new File(dataDirectory, "players.txt");
        BufferedReader playerReader = null;
        Player player = null;
        
        // Return null if the players data file does not yet exist.
        if ( ! playerFile.exists() ) {
            return null;
        }
        
        // Otherwise, loop through each record in the data file
        try {
            playerReader = new BufferedReader(new FileReader(playerFile));
            String record;
            
            // Read every record (one per line)
            while ( (record = playerReader.readLine()) != null ) {
                String[] fields = record.split("\t");
                
                // Extract the name field from the record
                String name = fields[0];
                
                // If this record does not match the SEARCH NAME,
                // then continue searching the data file
                if ( ! search_name.equals(name) ) {
                    continue;
                }
                
                // Otherwise, we have a match...
                // Extract the rest of the data fields
                String address = fields[1];
                String city = fields[2];
                String province = fields[3];
                String postalCode = fields[4];
                
                // Create the Player object from the data fields
                player = new Player(name, address, city, province, postalCode);
                
                // and break from the loop
                break;
                
            } // END while loop
            
        } catch (Exception e) {
            System.err.println(e);
            
            // Clean up IO resources
        } finally {
            if ( playerReader != null ) {
                try { playerReader.close(); } catch (IOException e) { System.err.println(e); }
            }
        }
        
        return player;
    }
    
    /**
     * This private method stores a single player to the data file.
     */
    private void storePlayer(Player player) {
        String playerFile = dataDirectory + "players.txt";
        PrintWriter playerWriter = null;
        
        try {
            // Open a writer stream and mark it to append the new data
            playerWriter = new PrintWriter(new FileWriter(playerFile, true));
            
            playerWriter.print(player.name);
            playerWriter.print('\t');
            playerWriter.print(player.address);
            playerWriter.print('\t');
            playerWriter.print(player.city);
            playerWriter.print('\t');
            playerWriter.print(player.province);
            playerWriter.print('\t');
            playerWriter.print(player.postalCode);
            playerWriter.println();
            
        } catch (Exception e) {
            System.err.println(e);
            
            // Clean up IO resources
        } finally {
            if ( playerWriter != null ) {
                try { playerWriter.close(); } catch (Exception e) { System.err.println(e); }
            }
        }
    }
}
