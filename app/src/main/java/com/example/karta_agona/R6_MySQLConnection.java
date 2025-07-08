package com.example.karta_agona;
import java.sql.Connection;
import java.sql.*;

public class R6_MySQLConnection implements Runnable{
    private int temp;
    private String match_name, total1, total2, team1, team2, win_team, points2_1, points2_2, points3_1, points3_2, freeshots1, freeshots2, offreb1, offreb2, defreb1, defreb2;
    private String assists1, assists2, blocks1, blocks2, steals1, steals2, turnovers1, turnovers2, fouls1, fouls2, gameDone, tempImage, image1, image2;
    private R6_DataCalculator dc=new R6_DataCalculator();
    /** Replace with your own IP address and port **/
    private String myIP;
    private int gameid;

    public R6_MySQLConnection(String url, int id){
        myIP=url;
        gameid=id;
    }

    @Override
    public void run() {
        System.out.println("Read match data from the MySQL Database!");
        Connection con;
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mariadb://"+myIP+":3306/basket_data", "test", "test");

            try {
                String p, made, attempted;
                int r, m, at;
                double temp;
                String sql;

                sql="SELECT * FROM basket_game, team WHERE team_name1=name OR team_name2=name ORDER BY game_id";
                /**
                 * Creates a new table which consists of the tables basket_game and team, classified by the id of the game.
                 * For each game two lines are produced, one for each team.
                 * Both lines share the same game data but one line contains the data of the first team that participated in the match
                 * while the other line contains the data of the second team
                 */

                PreparedStatement preparedStatement=con.prepareStatement(sql);
                ResultSet rs=preparedStatement.executeQuery();
                /**
                 * Scans the entire table to find the game with the given id
                 */
                rs.first();
                while (!(rs.getInt("game_id")==gameid)){
                    rs.next();
                }

                int ae = rs.getInt("game_id");
                match_name = String.valueOf(ae);
                team1 = rs.getString("team_name1");
                team2 = rs.getString("team_name2");
                tempImage=rs.getString("name");
                /**
                 * Finds which of the two teams' (1 or 2) data are displayed
                 * in order to put the url (which is placed inside the icon_path) into the correct ImageView
                 */
                image1="https://us.123rf.com/450wm/pavelstasevich/pavelstasevich1811/pavelstasevich181101027/112815900-no-image-available-icon-flat-vector.jpg";
                image2="https://us.123rf.com/450wm/pavelstasevich/pavelstasevich1811/pavelstasevich181101027/112815900-no-image-available-icon-flat-vector.jpg";
                if(!(rs.getString("icon_path").equals(""))){
                    if(team1.equals(tempImage)){
                        image1=rs.getString("icon_path");
                    }else{
                        image2=rs.getString("icon_path");
                    }
                }
                /**
                 * Finds the next row. This row shares the same basket_game data with its previous one
                 */
                rs.next();

                tempImage=rs.getString("name");
                /**
                 * Finds the url to the other team's logo
                 */
                if (!(rs.getString("icon_path").equals(""))) {
                    if (team1.equals(tempImage)) {
                        image1 = rs.getString("icon_path");
                    } else {
                        image2 = rs.getString("icon_path");
                    }
                }
                gameDone=rs.getString("finished_game");
                /**
                 * Checks if the game is finished before calculating the statistics
                 */
                if(gameDone.equals("1")) {
                    win_team = rs.getString("winning_team_name");
                    total1 = rs.getString("points1");
                    total2 = rs.getString("points2");

                    points2_1 = dc.valueConverter(rs.getInt("made2p_1"), rs.getInt("attempted2p_1"));
                    points2_2 = dc.valueConverter(rs.getInt("made2p_2"), rs.getInt("attempted2p_2"));
                    points3_1 = dc.valueConverter(rs.getInt("made3p_1"), rs.getInt("attempted3p_1"));
                    points3_2 = dc.valueConverter(rs.getInt("made3p_2"), rs.getInt("attempted3p_2"));
                    freeshots1 = dc.valueConverter(rs.getInt("madeft_1"), rs.getInt("attemptedft_1"));
                    freeshots2 = dc.valueConverter(rs.getInt("madeft_2"), rs.getInt("attemptedft_2"));
                    offreb1 = rs.getString("off_rebs1");
                    offreb2 = rs.getString("off_rebs2");
                    defreb1 = rs.getString("def_rebs1");
                    defreb2 = rs.getString("def_rebs2");
                    assists1 = rs.getString("assist1");
                    assists2 = rs.getString("assist2");
                    blocks1 = rs.getString("blocks1");
                    blocks2 = rs.getString("blocks2");
                    steals1 = rs.getString("steals1");
                    steals2 = rs.getString("steals2");
                    turnovers1 = rs.getString("turnovers1");
                    turnovers2 = rs.getString("turnovers2");
                    fouls1 = rs.getString("fouls1");
                    fouls2 = rs.getString("fouls2");

                }
                else {
                    total1 = "-";
                    total2 = "-";
                    points2_1 = "-";
                    points2_2 = "-";
                    points3_1 = "-";
                    points3_2 = "-";
                    freeshots1 = "-";
                    freeshots2 = "-";
                    offreb1 = "-";
                    offreb2 = "-";
                    defreb1 = "-";
                    defreb2 = "-";
                    assists1 = "-";
                    assists2 = "-";
                    blocks1 = "-";
                    blocks2 = "-";
                    steals1 = "-";
                    steals2 = "-";
                    turnovers1 = "-";
                    turnovers2 = "-";
                    fouls1 = "-";
                    fouls2 = "-";
                }
                preparedStatement.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                con.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /**
     * Methods to help other classes receive the calculated data
     */
    public String getMatch_name(){
        return match_name;
    }
    public String getTeam1(){
        return team1;
    }
    public String getTeam2(){
        return team2;
    }
    public String getImage1(){
        return image1;
    }
    public String getImage2(){
        return image2;
    }
    public String getTotal1(){
        return total1;
    }
    public String getTotal2(){
        return total2;
    }
    public String getPoints2_1(){
        return points2_1;
    }
    public String getPoints2_2(){
        return points2_2;
    }
    public String getPoints3_1(){
        return points3_1;
    }
    public String getPoints3_2(){
        return points3_2;
    }
    public String getFreeshots1(){
        return freeshots1;
    }
    public String getFreeshots2(){
        return freeshots2;
    }
    public String getOffreb1(){
        return offreb1;
    }
    public String getOffreb2(){
        return offreb2;
    }
    public String getDefreb1(){
        return defreb1;
    }
    public String getDefreb2(){
        return defreb2;
    }
    public String getAssists1(){
        return assists1;
    }
    public String getAssists2(){
        return assists2;
    }
    public String getBlocks1(){
        return blocks1;
    }
    public String getBlocks2(){
        return blocks2;
    }
    public String getSteals1(){
        return steals1;
    }
    public String getSteals2(){
        return steals2;
    }
    public String getTurnovers1() {
        return turnovers1;
    }
    public String getTurnovers2(){
        return turnovers2;
    }
    public String getFouls1(){
        return fouls1;
    }
    public String getFouls2(){
        return fouls2;
    }
}

