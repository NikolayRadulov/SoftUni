DELETE FROM games as g WHERE (SELECT Count(*) from games_categories as g_c Where g_c.game_id = g.id) = 0 AND g.release_date is NULL;