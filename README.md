# PreventTP
A teleport plugin for 1.10/1.10.2 that only allows teleporting to others.
This was made for my MC server that allows tp's but the issue with the normal tp command is you can tp others and I didnt want that.
So what I did was create PreventTP, just changes up the normal tp command.

![Example](https://github.com/SnubbyOWO/PreventTP/assets/87741849/9d59d523-1b3b-4947-979f-74a76a4f30cc)

## Commands

- tp <player> = Limits the normal teleport command to only allow the player to tp to someone else.
- tpn <player1> <player2> = Admin teleport command
- tpreload = reloads config

## Configuration 

Use a simple permissions plugin to get this to work. 

config.yml 
```bash
  # Messages
  cant_find_player: '&7Player not found.'
  teleported_message: '&7Teleported.'
  teleport_specify: '&7Please specify a player. /tp <player>'
  reloaded_message: '&7Reloaded configuration file'
  no_mr_perez: '&7You cannot teleport others man.. come on.. /tp <player>'
  no_permission: '&7You do not have permission use this command.'
  
  
  # Perms
  reload_permission: 'snubs.tpreload'
  permission_admin_tp: 'snubs.admin'
  permission_tp: 'snubs.tp'
```

## License

[MIT](https://choosealicense.com/licenses/mit/)
