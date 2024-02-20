# Forum

## Overview

...

## Requirements

- The forum system manages users, posts and comments.
- A user contains: id, name, email (unique), password, avatar url and creation timestamp.
- The user password must be stored encrypted.
- The system must have user authentication.
- The system must have access control.
- Each user on the system must have roles and permissions.
- The system must support two types of users: common and super users
- The system must support three main roles: administrators, authors and readers.
- Common users are, at the same time, authors and readers.
- Super users extend common users by being administrators (admins).
- Each role and permission contains: name (unique), description and creation timestamp.
- A user can have many contributions: posts and comments.
- A contribution can be created, updated and deleted by one author.
- When a user is deleted, he is disassociated from his contributions and rankings.
- When a contribution is deleted, only its content and authorship are removed.
- A post contains: id, title, content, timestamps (creation, last update) and comments.
- A post can be linked to multiple categories, improving search.
- A category contains: name (unique), description and creation timestamp.
- Categories must have unique names.
- Categories can only be created, updated and deleted by admins.
- A comment contains: node id, parent id, user id, content and timestamps (creation, last update).
- A comment can be linked to a post directly or indirectly by another comment (as a reply).
- A comment can be created, updated and deleted by one reader.
- Admins can delete inappropriate posts and comments from users.
- Deleting a comment does not affect its children.
- Posts and comments must be visible to any user of the system.
- Posts and comments can be ranked using and up/down-voting system.
- In the voting system, a user can only participate once, exclusively voting up or down.

## Diagrams

```mermaid
  erDiagram
    USER {
      String id PK
      String name
      String email UK
      String password
      String avatar_url
      int created_at
    }

    ROLE {
      String name PK
      String description
      int created_at
    }

    PERMISSION {
      String name PK
      String description
      int created_at
    }

    CONTRIBUTION {
      String id PK
      String author_id FK
      int created_at
      int last_update
    }

    POST {
      String id PK, FK
      String title
      String content
    }

    CATEGORY {
      String name PK
      String description
      String color
      int created_at
    }

    COMMENT {
      String id PK, FK
      String parent_id FK
      String content
    }

    RANKING {
      String user_id PK, FK
      String contribution_id PK, FK
      String vote
    }

    USER }o--o{ ROLE: performs
    ROLE }o--o{ PERMISSION: provides
    USER }o--o{ PERMISSION: has

    POST ||--|| CONTRIBUTION: inherits
    COMMENT ||--|| CONTRIBUTION: inherits

    CONTRIBUTION }o--|| USER: published_by

    POST }o--o{ CATEGORY: belongs_to

    POST ||--o{ COMMENT: contains
    COMMENT }o--|| COMMENT: replies

    CONTRIBUTION ||--o{ RANKING: classified_by
    RANKING }o--|| USER: participated_by
```
