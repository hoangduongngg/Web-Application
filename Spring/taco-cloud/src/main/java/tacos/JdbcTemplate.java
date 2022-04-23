//package tacos;
//
//public class JdbcTemplate {
//	 private JdbcTemplate jdbc;
//	 eOverride
//	 public Ingredient findOne(String id) {
//	 return jdbc.queryForObject (
//	 "select id, name, type from Ingredient where id=?",
//	 this::mapRowToIngredient, id);
//	 
//	 private Ingredient mapRowToIngredient (ResultSet rs, int rowNum)
//	 throws SQLException {
//	 return new Ingredient (
//	 rs.getString ("id"),
//	 rs.getString ( "name"),
//	 Ingredient.TyYpe.valueOf(rs.getString("type")));
//}
