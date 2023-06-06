Select g.`name`, (Case when g.budget < 50000 then 'Normal budget' ELSE 'Insufficient budget' END) as 'budget_level', t.`name`as 'team name', a.`name` as 'address name' from games as g 
JOIN teams as t on g.team_id = t.id
JOin offices as o on t.office_id = o.id
JOin addresses as a on o.address_id = a.id
where (SELECT Count(*) from games_categories as g_c Where g_c.game_id = g.id) = 0 AND g.release_date is NULL ORDER BY g.`name`;