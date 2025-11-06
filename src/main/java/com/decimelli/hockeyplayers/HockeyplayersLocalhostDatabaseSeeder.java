package com.decimelli.hockeyplayers;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.decimelli.hockeyplayers.model.HockeyTeam;
import com.decimelli.hockeyplayers.repository.HockeyTeamRepo;

@Component
@Profile("localhost")
public class HockeyplayersLocalhostDatabaseSeeder implements CommandLineRunner {

	private final HockeyTeamRepo teamDatabase;

	public HockeyplayersLocalhostDatabaseSeeder(HockeyTeamRepo teamDatabase) {
		this.teamDatabase = teamDatabase;
	}

	@Override
	public void run(String... args) throws Exception {
		teamDatabase.saveAll(
				List.of(
						new HockeyTeam("Anaheim Ducks"),
						new HockeyTeam("Utah Mammoth"),
						new HockeyTeam("Boston Bruins"),
						new HockeyTeam("Buffalo Sabres"),
						new HockeyTeam("Calgary Flames"),
						new HockeyTeam("Carolina Hurricanes"),
						new HockeyTeam("Chicago Blackhawks"),
						new HockeyTeam("Colorado Avalanche"),
						new HockeyTeam("Columbus Blue Jackets"),
						new HockeyTeam("Dallas Stars"),
						new HockeyTeam("Detroit Red Wings"),
						new HockeyTeam("Edmonton Oilers"),
						new HockeyTeam("Florida Panthers"),
						new HockeyTeam("Los Angeles Kings"),
						new HockeyTeam("Minnesota Wild"),
						new HockeyTeam("Montreal Canadiens"),
						new HockeyTeam("Nashville Predators"),
						new HockeyTeam("New Jersey Devils"),
						new HockeyTeam("New York Islanders"),
						new HockeyTeam("New York Rangers"),
						new HockeyTeam("Ottawa Senators"),
						new HockeyTeam("Philadelphia Flyers"),
						new HockeyTeam("Pittsburgh Penguins"),
						new HockeyTeam("San Jose Sharks"),
						new HockeyTeam("Seattle Kraken"),
						new HockeyTeam("St. Louis Blues"),
						new HockeyTeam("Tampa Bay Lightning"),
						new HockeyTeam("Toronto Maple Leafs"),
						new HockeyTeam("Vancouver Canucks"),
						new HockeyTeam("Vegas Golden Knights"),
						new HockeyTeam("Washington Capitals"),
						new HockeyTeam("Winnipeg Jets")));
	}

}
