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

    class User
    class Role
    class Permission

    class Admin
    class Reader
    class Author

    class Post
    class Category
    class Comment

    User -- Role
    Role -- Permission
    Permission -- User

    Admin --|> User
    Reader --|> User
    Author --|> User

    Post -- Category
    Post -- Author
    Post -- Admin

    Comment -- User
    Comment -- Post
    Comment -- Comment: reply
```
