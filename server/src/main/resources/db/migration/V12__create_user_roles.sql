CREATE TABLE user_roles (
  user_id VARCHAR(255) NOT NULL,
  role_name VARCHAR(255) NOT NULL,
  PRIMARY KEY (user_id, role_name),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
  FOREIGN KEY (role_name) REFERENCES roles (name) ON DELETE CASCADE
);
