select c.`name`, Count(c.`id`) as games_count, round(avg(g.`budget`), 2) as 'avg_budget', Max(g.`rating`) as `max_rating` from games_categories as c_g 
JOIN categories as c on c.id = c_g.category_id 
JOIN games as g on g.id = c_g.game_id GROUP BY c.`name` HAVING `max_rating` >= 9.5 ORDER BY games_count DESC, c.`name`;