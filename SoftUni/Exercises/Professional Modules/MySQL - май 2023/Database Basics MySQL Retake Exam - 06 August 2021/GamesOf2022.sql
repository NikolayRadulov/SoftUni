Select g.`name`, g.release_date, Concat(substring(g.`description`, 1, 10), '...') as 'summary', Concat("Q", quarter(g.release_date)) as 'quater', t.`name` as 'team_name' from games as g 
Join teams as t on g.team_id = t.id
Where g.`name` LIKE '%2' AND month(g.release_date) % 2 = 0 AND year(g.release_date) = 2022 ORDER BY g.release_date;