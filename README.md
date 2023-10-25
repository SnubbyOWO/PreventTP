# PreventTP
A teleport plugin for 1.10/1.10.2 that only allows teleporting to others.
This was made for my MC server that allows tp's but the issue with the normal tp command is you can tp others and I didnt want that.
So what I did was create PreventTP, just changes up the normal tp command. You can download it [here.](https://github.com/SnubbyOWO/PreventTP/raw/main/build/PreventTP.jar)

## Disclaimer
This is my first ever plugin and I've really not done much with java before. I'm still learning the basics and I know theres better out there but I want to practice a lot so I can get better.

Original [Concept](https://www.spigotmc.org/resources/new-teleportation-1-10-15-2-bug-fixed.74606/)

![Example](https://github.com/SnubbyOWO/PreventTP/blob/main/example.gif?raw=true)

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
  teleported_message: '&7Teleported to %Player%'
  teleport_specify: '&7Please specify a player. /tp <player>'
  reloaded_message: '&7Reloaded configuration file'
  no_mr_perez: '&7You cannot teleport others man.. come on.. /tp <player>'
  no_permission: '&7You do not have permission use this command.'
  added_player: '&7Added %Player% to the list.'
  punish_add_player: '&7You mean /tppunish <player> right?'
  player_already_in_list: '&7Player is already in the list.'
  blacklist_message: '&7You cannot teleport to this player ;)'
  
  # Call out Perez
  callout_mr_perez: '&7&l&nCmon %Player%, you cant teleport others! Learn not to abuse this power!'
  
  # Perms
  reload_permission: 'snubs.tpreload'
  permission_admin_tp: 'snubs.admin'
  permission_tp: 'snubs.tp'
  
  # Torture Players
  players:
     - "Player1"
  
  # Players who can't be tp'd to
  blacklist:
     - "Player1"
```

## Updates? 
no.

## License

[MIT](https://choosealicense.com/licenses/mit/)
