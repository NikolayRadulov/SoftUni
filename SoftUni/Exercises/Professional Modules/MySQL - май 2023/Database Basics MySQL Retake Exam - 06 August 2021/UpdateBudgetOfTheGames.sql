
create procedure udp_update_budget(min_game_rating FLOAT)
BEGIN
 UPDATE games as g SET g.budget = g.budget+100000, g.release_date = DATE_add(g.release_date, INTERVAL 1 year) WHERE (SELECT Count(*) from games_categories as g_c Where g_c.game_id = g.id) = 0 AND g.rating > min_game_rating AND g.release_date is NOT NULL;



END 
