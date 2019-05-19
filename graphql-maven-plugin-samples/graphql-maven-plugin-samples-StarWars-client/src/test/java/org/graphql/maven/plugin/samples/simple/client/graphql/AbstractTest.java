package org.graphql.maven.plugin.samples.simple.client.graphql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.graphql.maven.plugin.samples.simple.client.Queries;
import org.junit.jupiter.api.Test;

import com.generated.graphql.Character;
import com.generated.graphql.Droid;
import com.generated.graphql.Episode;
import com.generated.graphql.Human;

import graphql.java.client.response.GraphQLExecutionException;
import graphql.java.client.response.GraphQLRequestPreparationException;

/**
 * As it is suffixed by "IT", this is an integration test. Thus, it allows us to start the GraphQL StatWars server, see
 * the pom.xml file for details.
 * 
 * @author EtienneSF
 */
abstract class AbstractTest {

	Queries queries;

	@Test
	void testHeroFull() throws GraphQLExecutionException, GraphQLRequestPreparationException {
		// return queryType.hero("{id appearsIn name}", Episode.NEWHOPE);
		Character c = queries.heroFull();

		checkCharacter(c, "heroSimple", "2", "BB-8", 0, Episode.NEWHOPE);
	}

	@Test
	void testHeroPartial() throws GraphQLExecutionException, GraphQLRequestPreparationException {
		// return queryType.hero("{id appearsIn name}", Episode.NEWHOPE);
		Character c = queries.heroPartial();

		checkCharacter(c, "heroSimple", null, "BB-8", 0, Episode.NEWHOPE);
	}

	@Test
	void testHeroFriendsFriendsFriends() throws GraphQLExecutionException, GraphQLRequestPreparationException {
		// return queryType.hero("{id appearsIn friends {name friends {friends{id name appearsIn}}}}", Episode.NEWHOPE);
		Character c = queries.heroFriendsFriendsFriends();

		checkCharacter(c, "testHeroFriendsFriendsFriends", "2", null, 2, Episode.NEWHOPE);

		Character friends_0 = c.getFriends().get(0);
		checkCharacter(friends_0, "testHeroFriendsFriendsFriends[friends_0]", null, "Poe Dameron", 0);

		Character friends_1 = c.getFriends().get(1);
		checkCharacter(friends_1, "testHeroFriendsFriendsFriends[friends_1]", null, "Luke Skywalker", 3);

		Character friends_1_0 = friends_1.getFriends().get(0); // "24", "Padmé Amidala"
		checkCharacter(friends_1_0, "testHeroFriendsFriendsFriends[friends_1_0]", null, null, 1);
		Character friends_1_0_0 = friends_1_0.getFriends().get(0);
		checkCharacter(friends_1_0_0, "testHeroFriendsFriendsFriends[friends_1_0]", "179", "Anakin Skywalker", 0,
				Episode.NEWHOPE);

		Character friends_1_1 = friends_1.getFriends().get(1); // "94", "Mara Jade"
		checkCharacter(friends_1_1, "testHeroFriendsFriendsFriends[friends_1_0]", null, null, 1);
		Character friends_1_1_0 = friends_1_1.getFriends().get(0);
		checkCharacter(friends_1_1_0, "testHeroFriendsFriendsFriends[friends_1_0]", "180", "Luke Skywalker", 0,
				Episode.EMPIRE);

		Character friends_1_2 = friends_1.getFriends().get(2); // "179", "Anakin Skywalker"
		checkCharacter(friends_1_2, "testHeroFriendsFriendsFriends[friends_1_0]", null, null, 2);
		Character friends_1_2_0 = friends_1_2.getFriends().get(0);
		checkCharacter(friends_1_2_0, "testHeroFriendsFriendsFriends[friends_1_0]", "8", "Obi-Wan Kenobi", 0,
				Episode.NEWHOPE);
		Character friends_1_2_1 = friends_1_2.getFriends().get(1);
		checkCharacter(friends_1_2_1, "testHeroFriendsFriendsFriends[friends_1_0]", "213", "Dark Vador", 0,
				Episode.NEWHOPE);
	}

	@Test
	void testHumanFull() throws GraphQLExecutionException, GraphQLRequestPreparationException {
		// queryType.human("{id appearsIn homePlanet name}", "45");
		Human h = queries.humanFull();

		checkCharacter(h, "testHeroFriendsFriendsFriends[friends_1_0]", "45", "Joruus C'Baoth", 0, Episode.EMPIRE);
		assertEquals("Kashyyyk", h.getHomePlanet());
	}

	@Test
	void testHumanPartial() throws GraphQLExecutionException, GraphQLRequestPreparationException {
		// queryType.human("{appearsIn homePlanet name}", "45");
		Human h = queries.humanPartial();

		checkCharacter(h, "humanPartial", null, "Joruus C'Baoth", 0, Episode.EMPIRE);
		assertEquals("Kashyyyk", h.getHomePlanet());
	}

	@Test
	void testHumanFriendsFriendsFriends() throws GraphQLExecutionException, GraphQLRequestPreparationException {
		// queryType.human("{id appearsIn name friends {name friends {friends{id name appearsIn}}}}", "180");
		Human h = queries.humanFriendsFriendsFriends();

		checkCharacter(h, "testHeroFriendsFriendsFriends[friends_1]", "180", "Luke Skywalker", 3, Episode.EMPIRE);
		assertNull(h.getHomePlanet());

		Character friends_0 = h.getFriends().get(0); // "24", "Padmé Amidala"
		checkCharacter(friends_0, "testHeroFriendsFriendsFriends[friends_0]", null, "Padme Amidala", 1);
		//
		Character friends_0_0 = friends_0.getFriends().get(0); // "179", "Anakin Skywalker"
		checkCharacter(friends_0_0, "testHeroFriendsFriendsFriends[friends_0]", null, null, 2);

		Character friends_1 = h.getFriends().get(1); // "94", "Mara Jade"
		checkCharacter(friends_1, "testHeroFriendsFriendsFriends[friends_0]", null, "Mara Jade", 1);
		Character friends_1_0 = friends_1.getFriends().get(0); // "180", "Luke Skywalker"
		checkCharacter(friends_1_0, "testHeroFriendsFriendsFriends[friends_0]", null, null, 3);

		Character friends_2 = h.getFriends().get(2); // "179", "Anakin Skywalker"
		checkCharacter(friends_2, "testHeroFriendsFriendsFriends[friends_0]", null, "Anakin Skywalker", 2);
		Character friends_2_0 = friends_2.getFriends().get(0); // "8", "Obi-Wan Kenobi"
		checkCharacter(friends_2_0, "testHeroFriendsFriendsFriends[friends_0]", null, null, 4);
		Character friends_2_1 = friends_2.getFriends().get(1); // "213", "Dark Vador"
		checkCharacter(friends_2_1, "testHeroFriendsFriendsFriends[friends_0]", null, null, 3);
	}

	@Test
	void testDroidFull() throws GraphQLExecutionException, GraphQLRequestPreparationException {
		// queryType.droid("{id appearsIn primaryFunction name}", "3");
		Droid d = queries.droidFull();

		checkCharacter(d, "droidSimple", "3", "C-3PO", 0, Episode.EMPIRE);
		assertEquals("Function of C-3PO", d.getPrimaryFunction());
	}

	@Test
	void testDroidSimple() throws GraphQLExecutionException, GraphQLRequestPreparationException {
		// queryType.droid("{id appearsIn primaryFunction name}", "3");
		Droid d = queries.droidPartial();

		checkCharacter(d, "droidSimple", null, "C-3PO", 0, Episode.EMPIRE);
		assertEquals("Function of C-3PO", d.getPrimaryFunction());
	}

	@Test
	void testDroidFriendsFriendsFriends() throws GraphQLExecutionException, GraphQLRequestPreparationException {
		// droid("{id appearsIn name friends {name friends {friends{id name appearsIn}}} primaryFunction }", "2");
		Droid d = queries.droidFriendsFriendsFriends();

		checkCharacter(d, "testDroidFriendsFriendsFriends", "2", "BB-8", 2, Episode.NEWHOPE);
		assertEquals("Function of BB-8", d.getPrimaryFunction());

		Character friends_0 = d.getFriends().get(0); // "52", "Poe Dameron"
		checkCharacter(friends_0, "testDroidFriendsFriendsFriends[friends_0]", null, "Poe Dameron", 0);

		Character friends_1 = d.getFriends().get(1); // "180", "Luke Skywalker"
		checkCharacter(friends_1, "testDroidFriendsFriendsFriends[friends_1]", null, "Luke Skywalker", 3);
	}

	@Test
	void testDroidDoesNotExist() throws GraphQLExecutionException, GraphQLRequestPreparationException {
		assertNull(queries.droidDoesNotExist());
	}

	private void checkCharacter(Character c, String testDecription, String id, String name, int nbFriends,
			Episode... episodes) {
		assertEquals(id, c.getId(), testDecription + " (id)");
		assertEquals(name, c.getName(), testDecription + " (name)");

		if (nbFriends == 0) {
			// c.getFriends() may be null
			if (c.getFriends() != null) {
				assertEquals(0, c.getFriends().size(), testDecription + " (friends)");
			}
		} else {
			assertEquals(nbFriends, c.getFriends().size(), testDecription + " (friends)");
		}
		if (episodes.length == 0) {
			assertNull(c.getAppearsIn(), testDecription + " (appearsIn null)");
		} else {
			assertEquals(episodes.length, c.getAppearsIn().size(), testDecription + " (nb appearsIn)");
			int i = 0;
			for (Episode e : episodes) {
				assertEquals(e, c.getAppearsIn().get(i), testDecription + " (appearsIn num" + i + ")");
				i += 1;
			}
		}
	}
}
