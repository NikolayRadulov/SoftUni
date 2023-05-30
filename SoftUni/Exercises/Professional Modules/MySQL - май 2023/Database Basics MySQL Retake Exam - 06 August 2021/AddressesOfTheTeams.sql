Select t.`name` as 'team_name', a.`name` as 'address_name', length(a.`name`) as 'count_of_characters' from teams as t 
JOIN offices as o on t.office_id = o.id 
JOIN addresses as a on o.address_id = a.id Where o.website is not NULL ORDER BY t.`name`, a.`name`;