CREATE TABLE IF NOT EXISTS "demo_board"
(
    "id"          bigint   NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    "name"        varchar  NOT NULL,
    "status"      varchar  NOT NULL,
    "creator"     varchar           DEFAULT '',
    "create_time" datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "updater"     varchar           DEFAULT '',
    "update_time" datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    "deleted"     bit      NOT NULL DEFAULT FALSE,
    PRIMARY KEY ("id")
) COMMENT '格局版 demo';