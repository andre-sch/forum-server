CREATE TABLE user_permissions (
  user_id VARCHAR(255) NOT NULL,
  permission_name VARCHAR(255) NOT NULL,
  PRIMARY KEY (user_id, permission_name),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
  FOREIGN KEY (permission_name)
    REFERENCES permissions (name)
    ON DELETE CASCADE
);
