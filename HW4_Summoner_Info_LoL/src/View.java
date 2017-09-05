import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class View {

	/** The label array */
	private String[] labelArr;
	/** The search button. */
	private JButton searchButton;
	/** The main frame. */
	private JFrame mainFrame;
	/** The main panel. */
	private JPanel mainPanel;
	/** The summoner text field. */
	private JTextField summonerTextField;
	/** The summoner name label. */
	private JLabel summonerNameLabel;
	/** The server location. */
	private JTextField serverLocation;
	/** The server location label. */
	private JLabel serverLocationLabel;
	/** The game number. */
	private JLabel[] gameNumber;
	/** The blank fields. */
	private JTextField[] blankFields;
	/** The count. */
	private int count;
	/** The summoner ID. */
	private int summonerID;
	/** The champion ID. */
	private int championID;
	/** The kills. */
	private int kills;
	/** The deaths. */
	private int deaths;
	/** The assists. */
	private int assists;
	/** The team color ID. */
	private int teamColorID;
	/** The minions killed. */
	private int minionKills;
	/** The neutral minions killed. */
	private int neutralMinions;
	/** The kills/deaths/assists in string form. */
	private String kda;
	/** The champion name. */
	private String championName;
	/** The sub game type. */
	private String subType;
	/** The game type. */
	private String gameType;
	/** The win or loss. */
	private String winLoss;
	/** The team color. */
	private String teamColor;
	/** The server that is played on. */
	private String server;

	/**
	 * Main window.
	 */
	public void mainWindow() {
		count = 0;
		gameNumber = new JLabel[10];
		blankFields = new JTextField[70];
		for (int i = 0; i < 70; i++) {
			blankFields[i] = new JTextField();
			blankFields[i].setEditable(false);
			blankFields[i].setBorder(javax.swing.BorderFactory.createEmptyBorder());
		}
		// mainPanel is the panel that contains everything with the gui
		mainFrame = new JFrame("League of Legends Summoner Search");
		mainPanel = new JPanel();
		mainFrame.setLayout(new FlowLayout());
		mainPanel.setLayout(new GridLayout(0, 8));
		mainPanel.setSize(600, 300);
		// Creating the summoner name and server locations text fields and labels
		summonerTextField = new JTextField();
		summonerNameLabel = new JLabel("Summoner Name");
		summonerNameLabel.setSize(1, 1);
		serverLocation = new JTextField();
		serverLocationLabel = new JLabel("Server Location (e.g., na, eu)");
		serverLocationLabel.setSize(1, 1);

		searchButton = new JButton("Search for Statistics");
		labelArr = new String[] { "Game Type", "Sub Game Type", "Wins/Loss", "Champion Played", "Kills/Deaths/Assists",
				"Minion Kills", "Team Color" };
		serverLocationLabel = new JLabel("Server Location");
		serverLocation = new JTextField();

		// adding to the main panel
		mainPanel.add(new JLabel(" "));
		mainPanel.add(serverLocationLabel);
		mainPanel.add(serverLocation);
		mainPanel.add(new JLabel(" "));
		mainPanel.add(summonerNameLabel);
		mainPanel.add(summonerTextField);
		mainPanel.add(new JLabel(" "));
		mainPanel.add(searchButton);
		mainPanel.add(new JLabel(" "));
		// for loop to add the labels of summoner info searched
		for (int i = 0; i < labelArr.length; i++) {
			mainPanel.add(new JLabel(labelArr[i]));
		}
		for (int i = 0; i < 10; i++) {
			gameNumber[i] = new JLabel("Game " + (i + 1));
			mainPanel.add(gameNumber[i]);
			for (int j = 0; j < 7; j++) {
				mainPanel.add(blankFields[count]);
				count++;
			}
		}

		// making the frame visible
		mainPanel.setOpaque(false);
		mainFrame.add(mainPanel);
		mainFrame.setSize(750, 750);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.pack();
		mainFrame.setVisible(true);

		searchButton.addActionListener(new searchButtonHandler());
	}

	/**
	 * Read URL.
	 *
	 * @param webservice
	 *            string
	 * @return a string
	 * @throws Exception
	 */
	public String readURL(String webservice) throws Exception {
		URL oracle = new URL(webservice);
		BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));
		String inputLine;
		String result = "";

		while ((inputLine = in.readLine()) != null) {
			result = result + inputLine;
		}
		in.close();
		return result;
	}

	/**
	 * The Class searchButtonHandler.
	 */
	// Action handler to do all of the work for the code.
	public class searchButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String summoner = summonerTextField.getText();
			summoner = summoner.replaceAll("\\s+", "").toLowerCase();
			server = serverLocation.getText();

			try {
				String JSonString = readURL("https://" + server + ".api.pvp.net/api/lol/" + server
						+ "/v1.4/summoner/by-name/" + summoner + "?api_key=47ed153d-9890-427c-99e9-0679cffd651d");
				JSONObject summName = JSONObject.fromObject(JSonString);
				JSONObject summonerName = (JSONObject) summName.get(summoner);
				summonerID = (int) summonerName.get("id");
				String JSonRecentGames = readURL(
						"https://" + server + ".api.pvp.net/api/lol/" + server + "/v1.3/game/by-summoner/" + summonerID
								+ "/recent?api_key=47ed153d-9890-427c-99e9-0679cffd651d");
				JSONObject recentGames = JSONObject.fromObject(JSonRecentGames);
				JSONArray recentGameStats = recentGames.getJSONArray("games");
				count = 0;
				for (int games = 0; games < 10; games++) {
					// Changing the most recent game throughout the for loop
					JSONObject game = recentGameStats.getJSONObject(games);
					championID = game.getInt("championId");

					// Finding the game mode that was played during this game
					gameType = game.getString("gameMode");
					blankFields[count].setText(gameType);
					count++;

					// Finding the game mode that was played during this game
					subType = game.getString("subType");
					blankFields[count].setText(subType);
					count++;

					JSONObject gameStats = game.getJSONObject("stats");
					// Finding if the summoner won or lost the game
					winLoss = gameStats.getString("win");
					if (winLoss == "true") {
						winLoss = "Victory";
					} else {
						winLoss = "Defeat";
					}
					blankFields[count].setText(winLoss);
					count++;

					// Finding the name and the ID of the champion played in the
					// game
					String JSonChampName = readURL("https://global.api.pvp.net/api/lol/static-data/" + server
							+ "/v1.2/champion/" + championID + "?api_key=47ed153d-9890-427c-99e9-0679cffd651d");
					JSONObject champion = JSONObject.fromObject(JSonChampName);
					championName = champion.getString("name");
					championName += " " + champion.getString("title");
					blankFields[count].setText(championName);
					count++;

					// Finding the kills, deaths, and assists in this game
					if (gameStats.has("championsKilled"))
						kills = gameStats.getInt("championsKilled");
					else
						kills = 0;
					if (gameStats.has("numDeaths"))
						deaths = gameStats.getInt("numDeaths");
					else
						deaths = 0;
					if (gameStats.has("assists"))
						assists = gameStats.getInt("assists");
					else
						assists = 0;
					kda = kills + "/" + deaths + "/" + assists;
					blankFields[count].setText(kda);
					count++;

					// Finding the number of minions killed in this game
					if (gameStats.has("minionsKilled"))
						minionKills = gameStats.getInt("minionsKilled");
					else
						minionKills = 0;
					if (gameStats.has("neutralMinionsKilled")) {
						neutralMinions = gameStats.getInt("neutralMinionsKilled");
						minionKills += neutralMinions;
						blankFields[count].setText(minionKills + "");
						count++;
					} else {
						neutralMinions = 0;
						blankFields[count].setText(minionKills + "");
						count++;
					}

					// Finding the team color of the player during this game
					teamColorID = game.getInt("teamId");
					if (teamColorID == 100) {
						teamColor = "Blue";
					} else {
						teamColor = "Red";
					}
					blankFields[count].setText(teamColor);
					count++;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}
