CREATE sequence jobleads_auto start with 1
increment by 1;

INSERT INTO jobleads (lead_id, company, position, location, contact_name, contact_method, notes, contact_date) VALUES (jobleads_auto.nextval, 'Best Buy', 'Floor Executive', 'Mall of America', 'Chip', '56585578', 'Full-Time', 'February 25');