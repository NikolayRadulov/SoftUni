
create function udf_game_info_by_name(game_name VARCHAR(20))
RETURNS TEXT
DETERMINISTIC
BEGIN

DECLARE team, address TEXT;
SET team := (SELECT t.`name` from games as g JOIN teams as t on g.team_id = t.id WHERE g.`name` = game_name);
SET address := (SELECT a.`name` from games as g JOIN teams as t on g.team_id = t.id JOIN offices as o on t.office_id = o.id JOIN addresses as a on o.address_id = a.id WHERE g.`name` = game_name);

RETURN CONCAT_WS(' ', "The", game_name, 'is developed by a', team, 'in an office with an address', address);

END 
