CREATE TABLE role_permissions (
  role_name VARCHAR(255) NOT NULL,
  permission_name VARCHAR(255) NOT NULL,
  PRIMARY KEY (role_name, permission_name),
  FOREIGN KEY (role_name) REFERENCES roles (name) ON DELETE CASCADE,
  FOREIGN KEY (permission_name)
    REFERENCES permissions (name)
    ON DELETE CASCADE
);
