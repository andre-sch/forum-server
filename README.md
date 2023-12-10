# Blog

## Actors

- Reader
- Writer/author
- Admin

## Features

- Access control: users, roles, permissions
- Blog post CRUD, categorization and search
- Comment/reply CRUD, liking (or up/down-voting)

## Requirements

...

## Diagrams

```mermaid
  classDiagram
    direction LR

    class User {
      id: String
      name: String
      email: String
      password: String
      created_at: int
    }

    class Role {
      name: String
      description: String
      created_at: int
    }

    class Permission {
      name: String
      description: String
      created_at: int
    }

    class Post {
      id: String
      title: String
      content: String
      created_at: int
      last_update: int
    }

    class Category {
      id: String
      parent_id: String
      name: String
      description: String
      created_at: int
    }

    class Comment {
      id: String
      parent_id: String
      user_id: String
      content: String
      created_at: int
      last_update: int
    }

    class Rank {
      up_votes: String[]
      down_votes: String[]
    }

    User "*" -- "*" Role
    Role "*" -- "*" Permission
    Permission "*" -- "*" User

    Comment "*" -- "1" User
    Post "*" -- "1" User

    Post "*" -- "*" Category
    Category "*" --o "1" Category: nest

    Post "1" *-- "*" Comment
    Comment "*" --o "1" Comment: reply

    Comment "1" -- "1" Rank
    Post "1" -- "1" Rank
```
