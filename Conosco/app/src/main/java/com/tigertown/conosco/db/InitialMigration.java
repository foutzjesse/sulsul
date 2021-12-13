package com.tigertown.conosco.db;
import com.tigertown.conosco.db.contracts.*;
import java.util.*;

public final class InitialMigration
{
	private InitialMigration() {}
	
	public static final List<String> TABLES = Arrays.asList(
		//domain tables
		AnniversaryTypes.CREATE_TABLE,
		FaveTypes.CREATE_TABLE,
		Groups.CREATE_TABLE,
		Names.CREATE_TABLE,
		Peeps.CREATE_TABLE,
		RelationshipTypes.CREATE_TABLE,
		Traits.CREATE_TABLE,
		//fk tables
		Anniversaries.CREATE_TABLE,
		AnniversariesPeeps.CREATE_TABLE,
		EducationData.CREATE_TABLE,
		Faves.CREATE_TABLE,
		FavesPeeps.CREATE_TABLE,
		GiftIdeas.CREATE_TABLE,
		GroupsPeeps.CREATE_TABLE,
		NamesPeeps.CREATE_TABLE,
		Relationships.CREATE_TABLE,
		TraitsPeeps.CREATE_TABLE,
		ContactsPeeps.CREATE_TABLE
		);
		
	public static final String ANNIVERSARYTYPES =
		"INSERT INTO " + AnniversaryTypes.TABLE_NAME +
		" (" + AnniversaryTypes.NAME + ") " +
		"VALUES ('Birthday'), " +
		"('Relationship'), " +
		"('Sobriety'), " +
		"('Wedding')";
	
	public static final String FAVETYPES =
		"INSERT INTO " + FaveTypes.TABLE_NAME +
		" (" + FaveTypes.NAME + ") " +
		"VALUES ('Animal'), " +
		"('Book'), " +
		"('Color'), " +
		"('Food'), " +
		"('Game'), " +
		"('Movie'), " +
		"('Music'), " +
		"('Season'), " +
		"('Sports team'), " +
		"('TV show'), " +
		"('Vacation spot')";
	
	public static final String RELATIONSHIPTYPES =
		"INSERT INTO " + RelationshipTypes.TABLE_NAME +
		" (" + RelationshipTypes.NAME + ") " +
		"VALUES ('Spouse'), " +
		"('Parent'), " +
		"('Child'), " +
		"('Grandparent'), " +
		"('Grandchild'), " +
		"('Sibling'), " +
		"('Cousin'), " +
		"('Friend'), " +
		"('Romantic partner'), " +
		"('Business partner'), " +
		"('Colleague')";
}
