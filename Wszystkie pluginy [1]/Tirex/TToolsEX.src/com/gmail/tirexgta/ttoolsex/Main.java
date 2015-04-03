/*   1:    */ package com.gmail.tirexgta.ttoolsex;
/*   2:    */ 
/*   3:    */ import com.gmail.tirexgta.ttoolsex.commands.BanCommand;
/*   4:    */ import com.gmail.tirexgta.ttoolsex.commands.BroadcastCommand;
/*   5:    */ import com.gmail.tirexgta.ttoolsex.commands.ClearCommand;
/*   6:    */ import com.gmail.tirexgta.ttoolsex.commands.DispenserCommand;
/*   7:    */ import com.gmail.tirexgta.ttoolsex.commands.EnchantCommand;
/*   8:    */ import com.gmail.tirexgta.ttoolsex.commands.FlyCommand;
/*   9:    */ import com.gmail.tirexgta.ttoolsex.commands.GameModeCommand;
/*  10:    */ import com.gmail.tirexgta.ttoolsex.commands.GiveCommand;
/*  11:    */ import com.gmail.tirexgta.ttoolsex.commands.GodCommand;
/*  12:    */ import com.gmail.tirexgta.ttoolsex.commands.HatCommand;
/*  13:    */ import com.gmail.tirexgta.ttoolsex.commands.HeadCommand;
/*  14:    */ import com.gmail.tirexgta.ttoolsex.commands.HealCommand;
/*  15:    */ import com.gmail.tirexgta.ttoolsex.commands.HelpCommand;
/*  16:    */ import com.gmail.tirexgta.ttoolsex.commands.HomeCommand;
/*  17:    */ import com.gmail.tirexgta.ttoolsex.commands.IgnoreCommand;
/*  18:    */ import com.gmail.tirexgta.ttoolsex.commands.InvincibleCommand;
/*  19:    */ import com.gmail.tirexgta.ttoolsex.commands.ItemCommand;
/*  20:    */ import com.gmail.tirexgta.ttoolsex.commands.KickCommand;
/*  21:    */ import com.gmail.tirexgta.ttoolsex.commands.KickallCommand;
/*  22:    */ import com.gmail.tirexgta.ttoolsex.commands.ListCommand;
/*  23:    */ import com.gmail.tirexgta.ttoolsex.commands.MessageCommand;
/*  24:    */ import com.gmail.tirexgta.ttoolsex.commands.MuteCommand;
/*  25:    */ import com.gmail.tirexgta.ttoolsex.commands.PlecakCommand;
/*  26:    */ import com.gmail.tirexgta.ttoolsex.commands.RandomTeleportCommand;
/*  27:    */ import com.gmail.tirexgta.ttoolsex.commands.RangaCommand;
/*  28:    */ import com.gmail.tirexgta.ttoolsex.commands.RangiCommand;
/*  29:    */ import com.gmail.tirexgta.ttoolsex.commands.ReloadToolsCommand;
/*  30:    */ import com.gmail.tirexgta.ttoolsex.commands.RepairCommand;
/*  31:    */ import com.gmail.tirexgta.ttoolsex.commands.ReplyCommand;
/*  32:    */ import com.gmail.tirexgta.ttoolsex.commands.SetSpawnCommand;
/*  33:    */ import com.gmail.tirexgta.ttoolsex.commands.SethomeCommand;
/*  34:    */ import com.gmail.tirexgta.ttoolsex.commands.SkinCommand;
/*  35:    */ import com.gmail.tirexgta.ttoolsex.commands.SlotManagerCommand;
/*  36:    */ import com.gmail.tirexgta.ttoolsex.commands.SpawnCommand;
/*  37:    */ import com.gmail.tirexgta.ttoolsex.commands.SpawnerCommand;
/*  38:    */ import com.gmail.tirexgta.ttoolsex.commands.SpeedCommand;
/*  39:    */ import com.gmail.tirexgta.ttoolsex.commands.TellCommand;
/*  40:    */ import com.gmail.tirexgta.ttoolsex.commands.TimeCommand;
/*  41:    */ import com.gmail.tirexgta.ttoolsex.commands.TpCommand;
/*  42:    */ import com.gmail.tirexgta.ttoolsex.commands.TpaCommand;
/*  43:    */ import com.gmail.tirexgta.ttoolsex.commands.TpacceptCommand;
/*  44:    */ import com.gmail.tirexgta.ttoolsex.commands.TpdenyCommand;
/*  45:    */ import com.gmail.tirexgta.ttoolsex.commands.TpposCommand;
/*  46:    */ import com.gmail.tirexgta.ttoolsex.commands.UnbanCommand;
/*  47:    */ import com.gmail.tirexgta.ttoolsex.commands.UnmuteCommand;
/*  48:    */ import com.gmail.tirexgta.ttoolsex.commands.WeatherCommand;
/*  49:    */ import com.gmail.tirexgta.ttoolsex.commands.WymianaCommand;
/*  50:    */ import com.gmail.tirexgta.ttoolsex.database.DataUser;
/*  51:    */ import com.gmail.tirexgta.ttoolsex.database.Datasource;
/*  52:    */ import com.gmail.tirexgta.ttoolsex.listeners.BackpackListener;
/*  53:    */ import com.gmail.tirexgta.ttoolsex.listeners.BanListener;
/*  54:    */ import com.gmail.tirexgta.ttoolsex.listeners.BlockedStrenghtListener;
/*  55:    */ import com.gmail.tirexgta.ttoolsex.listeners.ColorSignListener;
/*  56:    */ import com.gmail.tirexgta.ttoolsex.listeners.DispensersListener;
/*  57:    */ import com.gmail.tirexgta.ttoolsex.listeners.GodListener;
/*  58:    */ import com.gmail.tirexgta.ttoolsex.listeners.InvincibleListener;
/*  59:    */ import com.gmail.tirexgta.ttoolsex.listeners.MuteListener;
/*  60:    */ import com.gmail.tirexgta.ttoolsex.listeners.PermissionsCommandsListener;
/*  61:    */ import com.gmail.tirexgta.ttoolsex.listeners.RandomTeleportListener;
/*  62:    */ import com.gmail.tirexgta.ttoolsex.listeners.RangListener;
/*  63:    */ import com.gmail.tirexgta.ttoolsex.listeners.RegenerationHeartListener;
/*  64:    */ import com.gmail.tirexgta.ttoolsex.listeners.SilentJoinLeaveListener;
/*  65:    */ import com.gmail.tirexgta.ttoolsex.listeners.SlotManagerListener;
/*  66:    */ import com.gmail.tirexgta.ttoolsex.listeners.StoneGeneratorListener;
/*  67:    */ import com.gmail.tirexgta.ttoolsex.listeners.TeleportCancelListener;
/*  68:    */ import com.gmail.tirexgta.ttoolsex.listeners.UserJoinLeaveListener;
/*  69:    */ import com.gmail.tirexgta.ttoolsex.listeners.WelcomeMessageListener;
/*  70:    */ import com.gmail.tirexgta.ttoolsex.others.Config;
/*  71:    */ import com.gmail.tirexgta.ttoolsex.others.Pokeball;
/*  72:    */ import com.gmail.tirexgta.ttoolsex.others.Recipe;
/*  73:    */ import java.util.HashMap;
/*  74:    */ import java.util.List;
/*  75:    */ import java.util.logging.Logger;
/*  76:    */ import java.util.regex.Matcher;
/*  77:    */ import java.util.regex.Pattern;
/*  78:    */ import net.milkbowl.vault.permission.Permission;
/*  79:    */ import org.bukkit.Bukkit;
/*  80:    */ import org.bukkit.ChatColor;
/*  81:    */ import org.bukkit.Location;
/*  82:    */ import org.bukkit.Material;
/*  83:    */ import org.bukkit.Server;
/*  84:    */ import org.bukkit.World;
/*  85:    */ import org.bukkit.entity.Player;
/*  86:    */ import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
/*  87:    */ import org.bukkit.plugin.Plugin;
/*  88:    */ import org.bukkit.plugin.PluginManager;
/*  89:    */ import org.bukkit.plugin.RegisteredServiceProvider;
/*  90:    */ import org.bukkit.plugin.ServicesManager;
/*  91:    */ import org.bukkit.plugin.java.JavaPlugin;
/*  92:    */ import org.bukkit.scheduler.BukkitScheduler;
/*  93:    */ import org.bukkit.scheduler.BukkitTask;
/*  94:    */ import org.bukkit.scoreboard.Scoreboard;
/*  95:    */ import org.bukkit.scoreboard.ScoreboardManager;
/*  96:    */ 
/*  97:    */ public class Main
/*  98:    */   extends JavaPlugin
/*  99:    */ {
/* 100:    */   public static Main plugin;
/* 101:    */   public static Logger log;
/* 102: 98 */   public static Permission chat = null;
/* 103:    */   public static ScoreboardManager manager;
/* 104:    */   public static Scoreboard board;
/* 105:    */   Plugin[] plugins;
/* 106:    */   public Config config;
/* 107:    */   DispenserCommand dispenserCommand;
/* 108:    */   BanCommand banCommand;
/* 109:    */   KickallCommand kickallCommand;
/* 110:    */   RangaCommand rangaCommand;
/* 111:    */   SetSpawnCommand setspawnCommand;
/* 112:    */   UnbanCommand unbanCommand;
/* 113:    */   WymianaCommand wymianaCommand;
/* 114:    */   BroadcastCommand broadcastCommand;
/* 115:    */   ClearCommand clearCommand;
/* 116:    */   EnchantCommand enchantCommand;
/* 117:    */   FlyCommand flyCommand;
/* 118:    */   GameModeCommand gameModeCommand;
/* 119:    */   GiveCommand giveCommand;
/* 120:    */   public GodCommand godCommand;
/* 121:    */   HatCommand hatCommand;
/* 122:    */   HeadCommand headCommand;
/* 123:    */   HealCommand healCommand;
/* 124:    */   HelpCommand helpCommand;
/* 125:    */   HomeCommand homeCommand;
/* 126:    */   IgnoreCommand ignoreCommand;
/* 127:    */   PlecakCommand plecakCommand;
/* 128:    */   InvincibleCommand invincibleCommand;
/* 129:    */   ItemCommand itemCommand;
/* 130:    */   KickCommand kickCommand;
/* 131:    */   ListCommand listcommand;
/* 132:    */   MessageCommand messageCommand;
/* 133:    */   MuteCommand muteCommand;
/* 134:    */   RepairCommand repairCommand;
/* 135:    */   public ReplyCommand replyCommand;
/* 136:    */   SethomeCommand sethomeCommand;
/* 137:    */   SlotManagerCommand slotManagerCommand;
/* 138:    */   SpawnCommand spawnCommand;
/* 139:    */   SpawnerCommand spawnerCommand;
/* 140:    */   SpeedCommand speedCommand;
/* 141:    */   TellCommand tellCommand;
/* 142:    */   TimeCommand timeCommand;
/* 143:    */   ReloadToolsCommand reloadToolsCommand;
/* 144:    */   TpCommand tpCommand;
/* 145:    */   public TpaCommand tpaCommand;
/* 146:    */   TpacceptCommand tpacceptCommand;
/* 147:    */   TpdenyCommand tpdenyCommand;
/* 148:    */   TpposCommand tpposCommand;
/* 149:    */   UnmuteCommand unmuteCommand;
/* 150:    */   WeatherCommand weatherCommand;
/* 151:    */   RandomTeleportCommand randomTeleportCommand;
/* 152:    */   SkinCommand skinCommand;
/* 153:    */   RangiCommand rangiCommand;
/* 154:    */   Recipe recipe;
/* 155:    */   Pokeball pokeball;
/* 156:    */   AutoMessageScheduler autoMessageScheduler;
/* 157:    */   SaveScheduler saveScheduler;
/* 158:    */   public DispensersManager dispensersManager;
/* 159:    */   public EffectManager effectManager;
/* 160:    */   public Enchantments enchantments;
/* 161:    */   public IgnoredManager ignoredManager;
/* 162:    */   public RangManager rangManager;
/* 163:    */   public BackpackManager backpackManager;
/* 164:    */   public InvincibleManager invincibleManager;
/* 165:    */   public LastTeleportManager lastTeleportManager;
/* 166:    */   public RandomTeleportManager randomTeleportManager;
/* 167:    */   public DispensersListener dispensersListener;
/* 168:    */   public SlotManagerListener slotManagerListener;
/* 169:    */   public GodListener godListener;
/* 170:    */   public TeleportCancelListener teleportCancelListener;
/* 171:    */   BanListener banListener;
/* 172:    */   RangListener rangListener;
/* 173:    */   BackpackListener backpackListener;
/* 174:    */   SilentJoinLeaveListener silentJoinLeaveListener;
/* 175:    */   UserJoinLeaveListener userJoinLeaveListener;
/* 176:    */   WelcomeMessageListener welcomeMessageListener;
/* 177:    */   InvincibleListener invincibleListener;
/* 178:    */   MuteListener muteListener;
/* 179:    */   PermissionsCommandsListener permissionsCommandsListener;
/* 180:    */   StoneGeneratorListener stoneGeneratorListener;
/* 181:    */   RegenerationHeartListener regenerationHeartListener;
/* 182:    */   public RandomTeleportListener randomTeleportListener;
/* 183:    */   ColorSignListener colorSignListener;
/* 184:    */   BlockedStrenghtListener blockedStrenghtListener;
/* 185:    */   public Datasource data;
/* 186:    */   DataUser dataUser;
/* 187:    */   
/* 188:    */   public void onEnable()
/* 189:    */   {
/* 190:194 */     plugin = this;
/* 191:195 */     log = getLogger();
/* 192:196 */     manager = Bukkit.getScoreboardManager();
/* 193:197 */     board = manager.getMainScoreboard();
/* 194:198 */     this.plugins = getPlugins();
/* 195:    */     
/* 196:200 */     this.config = new Config(this);
/* 197:    */     
/* 198:202 */     this.recipe = new Recipe(this);
/* 199:203 */     this.pokeball = new Pokeball(this);
/* 200:    */     
/* 201:205 */     this.giveCommand = new GiveCommand(this);
/* 202:206 */     this.gameModeCommand = new GameModeCommand(this);
/* 203:207 */     this.flyCommand = new FlyCommand(this);
/* 204:208 */     this.enchantCommand = new EnchantCommand(this);
/* 205:209 */     this.dispenserCommand = new DispenserCommand(this);
/* 206:210 */     this.banCommand = new BanCommand(this);
/* 207:211 */     this.kickallCommand = new KickallCommand(this);
/* 208:212 */     this.plecakCommand = new PlecakCommand(this);
/* 209:213 */     this.rangaCommand = new RangaCommand(this);
/* 210:214 */     this.setspawnCommand = new SetSpawnCommand(this);
/* 211:215 */     this.unbanCommand = new UnbanCommand(this);
/* 212:216 */     this.wymianaCommand = new WymianaCommand(this);
/* 213:217 */     this.broadcastCommand = new BroadcastCommand(this);
/* 214:218 */     this.clearCommand = new ClearCommand(this);
/* 215:219 */     this.godCommand = new GodCommand(this);
/* 216:220 */     this.hatCommand = new HatCommand(this);
/* 217:221 */     this.headCommand = new HeadCommand(this);
/* 218:222 */     this.healCommand = new HealCommand(this);
/* 219:223 */     this.helpCommand = new HelpCommand(this);
/* 220:224 */     this.homeCommand = new HomeCommand(this);
/* 221:225 */     this.ignoreCommand = new IgnoreCommand(this);
/* 222:226 */     this.invincibleCommand = new InvincibleCommand(this);
/* 223:227 */     this.itemCommand = new ItemCommand(this);
/* 224:228 */     this.kickCommand = new KickCommand(this);
/* 225:229 */     this.listcommand = new ListCommand(this);
/* 226:230 */     this.messageCommand = new MessageCommand(this);
/* 227:231 */     this.muteCommand = new MuteCommand(this);
/* 228:232 */     this.repairCommand = new RepairCommand(this);
/* 229:233 */     this.replyCommand = new ReplyCommand(this);
/* 230:234 */     this.sethomeCommand = new SethomeCommand(this);
/* 231:235 */     this.slotManagerCommand = new SlotManagerCommand(this);
/* 232:236 */     this.spawnCommand = new SpawnCommand(this);
/* 233:237 */     this.spawnerCommand = new SpawnerCommand(this);
/* 234:238 */     this.speedCommand = new SpeedCommand(this);
/* 235:239 */     this.tellCommand = new TellCommand(this);
/* 236:240 */     this.timeCommand = new TimeCommand(this);
/* 237:241 */     this.reloadToolsCommand = new ReloadToolsCommand(this);
/* 238:242 */     this.tpCommand = new TpCommand(this);
/* 239:243 */     this.tpaCommand = new TpaCommand(this);
/* 240:244 */     this.tpacceptCommand = new TpacceptCommand(this);
/* 241:245 */     this.tpdenyCommand = new TpdenyCommand(this);
/* 242:246 */     this.tpposCommand = new TpposCommand(this);
/* 243:247 */     this.unmuteCommand = new UnmuteCommand(this);
/* 244:248 */     this.weatherCommand = new WeatherCommand(this);
/* 245:249 */     this.randomTeleportCommand = new RandomTeleportCommand(this);
/* 246:250 */     this.skinCommand = new SkinCommand(this);
/* 247:    */     
/* 248:252 */     this.dispensersListener = new DispensersListener(this);
/* 249:253 */     this.slotManagerListener = new SlotManagerListener(this);
/* 250:254 */     this.godListener = new GodListener(this);
/* 251:255 */     this.teleportCancelListener = new TeleportCancelListener(this);
/* 252:256 */     this.rangListener = new RangListener(this);
/* 253:257 */     this.backpackListener = new BackpackListener(this);
/* 254:258 */     this.userJoinLeaveListener = new UserJoinLeaveListener(this);
/* 255:259 */     this.silentJoinLeaveListener = new SilentJoinLeaveListener(this);
/* 256:260 */     this.welcomeMessageListener = new WelcomeMessageListener(this);
/* 257:261 */     this.banListener = new BanListener(this);
/* 258:262 */     this.invincibleListener = new InvincibleListener(this);
/* 259:263 */     this.muteListener = new MuteListener(this);
/* 260:264 */     this.permissionsCommandsListener = new PermissionsCommandsListener(this);
/* 261:265 */     this.stoneGeneratorListener = new StoneGeneratorListener(this);
/* 262:266 */     this.regenerationHeartListener = new RegenerationHeartListener(this);
/* 263:267 */     this.randomTeleportListener = new RandomTeleportListener(this);
/* 264:268 */     this.colorSignListener = new ColorSignListener(this);
/* 265:269 */     this.blockedStrenghtListener = new BlockedStrenghtListener(this);
/* 266:    */     
/* 267:271 */     this.dispensersManager = new DispensersManager(this);
/* 268:272 */     this.autoMessageScheduler = new AutoMessageScheduler(this);
/* 269:273 */     this.saveScheduler = new SaveScheduler(this);
/* 270:274 */     this.enchantments = new Enchantments(this);
/* 271:275 */     this.ignoredManager = new IgnoredManager(this);
/* 272:276 */     this.rangManager = new RangManager(this);
/* 273:277 */     this.backpackManager = new BackpackManager(this);
/* 274:278 */     this.invincibleManager = new InvincibleManager(this);
/* 275:279 */     this.lastTeleportManager = new LastTeleportManager(this);
/* 276:280 */     this.randomTeleportManager = new RandomTeleportManager(this);
/* 277:    */     
/* 278:282 */     this.data = new Datasource(this);
/* 279:284 */     for (Player player : getServer().getOnlinePlayers())
/* 280:    */     {
/* 281:286 */       DataUser user = Datasource.getUserData(player);
/* 282:287 */       if (user == null)
/* 283:    */       {
/* 284:288 */         user = this.data.createUser();
/* 285:289 */         user.setNick(player.getName());
/* 286:290 */         exportPlayerData(user, player);
/* 287:291 */         user.insert();
/* 288:    */       }
/* 289:    */       else
/* 290:    */       {
/* 291:295 */         importPlayerData(user, player);
/* 292:    */       }
/* 293:    */     }
/* 294:302 */     setupChat();
/* 295:    */   }
/* 296:    */   
/* 297:    */   public void onDisable()
/* 298:    */   {
/* 299:308 */     for (Player online : )
/* 300:    */     {
/* 301:310 */       DataUser user = Datasource.getUserData(online);
/* 302:311 */       if (user != null)
/* 303:    */       {
/* 304:313 */         exportPlayerData(user, online);
/* 305:314 */         user.update();
/* 306:    */       }
/* 307:    */     }
/* 308:317 */     saveMap();
/* 309:318 */     this.data.saveAll();
/* 310:319 */     this.config.save();
/* 311:320 */     this.backpackManager.saveData();
/* 312:321 */     this.rangManager.saveData();
/* 313:322 */     this.ignoredManager.saveData();
/* 314:323 */     this.dispensersManager.saveData();
/* 315:324 */     this.invincibleManager.saveData();
/* 316:    */   }
/* 317:    */   
/* 318:    */   public static Main getThis()
/* 319:    */   {
/* 320:330 */     return plugin;
/* 321:    */   }
/* 322:    */   
/* 323:    */   private boolean setupChat()
/* 324:    */   {
/* 325:335 */     RegisteredServiceProvider<Permission> chatProvider = getServer().getServicesManager().getRegistration(Permission.class);
/* 326:336 */     if (chatProvider != null) {
/* 327:337 */       chat = (Permission)chatProvider.getProvider();
/* 328:    */     } else {
/* 329:341 */       log.info("§4Na serwerze nie ma pluginu §9Vault §4Plugin moze nie dzialac w 100% poprawnie!");
/* 330:    */     }
/* 331:344 */     return chat != null;
/* 332:    */   }
/* 333:    */   
/* 334:    */   public void saveMap()
/* 335:    */   {
/* 336:349 */     Bukkit.broadcastMessage(ChatColor.BLUE + "Trwa zapisywanie swiata...");
/* 337:350 */     Bukkit.savePlayers();
/* 338:351 */     for (World world : Bukkit.getWorlds()) {
/* 339:353 */       world.save();
/* 340:    */     }
/* 341:355 */     Bukkit.broadcastMessage(ChatColor.BLUE + "Swiat zostal pomyslnie zapisany.");
/* 342:    */   }
/* 343:    */   
/* 344:    */   public String fix(String s)
/* 345:    */   {
/* 346:360 */     if (s != null) {
/* 347:361 */       return ChatColor.translateAlternateColorCodes('&', s);
/* 348:    */     }
/* 349:362 */     return null;
/* 350:    */   }
/* 351:    */   
/* 352:    */   public int slot()
/* 353:    */   {
/* 354:367 */     return getServer().getOnlinePlayers().length;
/* 355:    */   }
/* 356:    */   
/* 357:    */   public boolean containsIgnoreCase(String[] board, String string)
/* 358:    */   {
/* 359:372 */     for (String otherstring : board) {
/* 360:374 */       if (otherstring.equalsIgnoreCase(string)) {
/* 361:376 */         return true;
/* 362:    */       }
/* 363:    */     }
/* 364:379 */     return false;
/* 365:    */   }
/* 366:    */   
/* 367:    */   public static Material getMaterial(String materialName)
/* 368:    */   {
/* 369:385 */     Material returnMaterial = null;
/* 370:386 */     if (isInteger(materialName))
/* 371:    */     {
/* 372:388 */       int id = Integer.parseInt(materialName);
/* 373:389 */       returnMaterial = Material.getMaterial(id);
/* 374:    */     }
/* 375:    */     else
/* 376:    */     {
/* 377:393 */       returnMaterial = Material.matchMaterial(materialName);
/* 378:    */     }
/* 379:395 */     return returnMaterial;
/* 380:    */   }
/* 381:    */   
/* 382:    */   public static boolean isDouble(String s)
/* 383:    */   {
/* 384:    */     try
/* 385:    */     {
/* 386:402 */       Double.parseDouble(s);
/* 387:    */     }
/* 388:    */     catch (NumberFormatException nfe)
/* 389:    */     {
/* 390:404 */       return false;
/* 391:    */     }
/* 392:406 */     return true;
/* 393:    */   }
/* 394:    */   
/* 395:    */   public static boolean isInteger(String s)
/* 396:    */   {
/* 397:    */     try
/* 398:    */     {
/* 399:413 */       Integer.parseInt(s);
/* 400:    */     }
/* 401:    */     catch (NumberFormatException nfe)
/* 402:    */     {
/* 403:415 */       return false;
/* 404:    */     }
/* 405:417 */     return true;
/* 406:    */   }
/* 407:    */   
/* 408:    */   public static boolean isFloat(String s)
/* 409:    */   {
/* 410:    */     try
/* 411:    */     {
/* 412:424 */       Float.parseFloat(s);
/* 413:    */     }
/* 414:    */     catch (NumberFormatException nfe)
/* 415:    */     {
/* 416:426 */       return false;
/* 417:    */     }
/* 418:428 */     return true;
/* 419:    */   }
/* 420:    */   
/* 421:    */   public static long stringToTime(String time)
/* 422:    */   {
/* 423:433 */     Pattern timePattern = Pattern.compile("(?:([0-9]+)\\s*y[a-z]*[,\\s]*)?(?:([0-9]+)\\s*mo[a-z]*[,\\s]*)?(?:([0-9]+)\\s*w[a-z]*[,\\s]*)?(?:([0-9]+)\\s*d[a-z]*[,\\s]*)?(?:([0-9]+)\\s*h[a-z]*[,\\s]*)?(?:([0-9]+)\\s*m[a-z]*[,\\s]*)?(?:([0-9]+)\\s*(?:s[a-z]*)?)?", 2);
/* 424:434 */     Matcher m = timePattern.matcher(time);
/* 425:435 */     long seconds = 0L;
/* 426:436 */     boolean found = false;
/* 427:437 */     while (m.find()) {
/* 428:439 */       if ((m.group() != null) && (!m.group().isEmpty()))
/* 429:    */       {
/* 430:441 */         for (int i = 0; i < m.groupCount(); i++) {
/* 431:443 */           if ((m.group(i) != null) && (!m.group(i).isEmpty()))
/* 432:    */           {
/* 433:445 */             found = true;
/* 434:446 */             break;
/* 435:    */           }
/* 436:    */         }
/* 437:449 */         if (found)
/* 438:    */         {
/* 439:451 */           if ((m.group(1) != null) && (!m.group(1).isEmpty())) {
/* 440:453 */             seconds += 31556926 * Integer.parseInt(m.group(1));
/* 441:    */           }
/* 442:455 */           if ((m.group(2) != null) && (!m.group(2).isEmpty())) {
/* 443:457 */             seconds += 2629743 * Integer.parseInt(m.group(2));
/* 444:    */           }
/* 445:459 */           if ((m.group(3) != null) && (!m.group(3).isEmpty())) {
/* 446:461 */             seconds += 604800 * Integer.parseInt(m.group(3));
/* 447:    */           }
/* 448:463 */           if ((m.group(4) != null) && (!m.group(4).isEmpty())) {
/* 449:465 */             seconds += 86400 * Integer.parseInt(m.group(4));
/* 450:    */           }
/* 451:467 */           if ((m.group(5) != null) && (!m.group(5).isEmpty())) {
/* 452:469 */             seconds += 3600 * Integer.parseInt(m.group(5));
/* 453:    */           }
/* 454:471 */           if ((m.group(6) != null) && (!m.group(6).isEmpty())) {
/* 455:473 */             seconds += 60 * Integer.parseInt(m.group(6));
/* 456:    */           }
/* 457:475 */           if ((m.group(7) != null) && (!m.group(7).isEmpty())) {
/* 458:477 */             seconds += Integer.parseInt(m.group(7));
/* 459:    */           }
/* 460:    */         }
/* 461:    */       }
/* 462:    */     }
/* 463:482 */     if (!found) {
/* 464:484 */       return -1L;
/* 465:    */     }
/* 466:486 */     return seconds * 1000L;
/* 467:    */   }
/* 468:    */   
/* 469:    */   public static void teleportPlayerWithDelay(Player player, int delayTime, final Location location, final String messageAfterTp, final Runnable postTeleport)
/* 470:    */   {
/* 471:492 */     if (plugin.teleportCancelListener.playerTeleportLocation.get(player) != null) {
/* 472:494 */       plugin.teleportCancelListener.playerTeleportLocation.remove(player);
/* 473:    */     }
/* 474:496 */     BukkitTask task = plugin.getServer().getScheduler().runTaskLater(plugin, new Runnable()
/* 475:    */     {
/* 476:    */       public void run()
/* 477:    */       {
/* 478:503 */         if (Main.this.isOnline())
/* 479:    */         {
/* 480:505 */           Main.this.teleport(location, PlayerTeleportEvent.TeleportCause.COMMAND);
/* 481:506 */           if (Main.plugin.teleportCancelListener.teleport.contains(Main.this)) {
/* 482:508 */             Main.plugin.teleportCancelListener.teleport.remove(Main.this);
/* 483:    */           }
/* 484:510 */           Main.plugin.teleportCancelListener.playerTeleportLocation.remove(Main.this);
/* 485:511 */           if (messageAfterTp != null) {
/* 486:513 */             Main.this.sendMessage(messageAfterTp);
/* 487:    */           }
/* 488:515 */           if (postTeleport != null) {
/* 489:516 */             postTeleport.run();
/* 490:    */           }
/* 491:    */         }
/* 492:    */       }
/* 493:519 */     }, delayTime * 20);
/* 494:520 */     plugin.teleportCancelListener.playerTeleportLocation.put(player, task);
/* 495:    */   }
/* 496:    */   
/* 497:    */   public void exportPlayerData(DataUser user, Player player)
/* 498:    */   {
/* 499:525 */     Location loc = player.getLocation();
/* 500:526 */     user.setWorld(loc.getWorld().getName());
/* 501:527 */     user.setX(loc.getBlockX());
/* 502:528 */     user.setY(loc.getBlockY());
/* 503:529 */     user.setZ(loc.getBlockZ());
/* 504:530 */     user.setGamemode(player.getGameMode());
/* 505:531 */     user.setFly(player.getAllowFlight());
/* 506:    */   }
/* 507:    */   
/* 508:    */   public void importPlayerData(DataUser user, Player player)
/* 509:    */   {
/* 510:535 */     player.setGameMode(user.getGamemode());
/* 511:536 */     player.setAllowFlight(user.getFly());
/* 512:    */   }
/* 513:    */   
/* 514:    */   public Plugin[] getPlugins()
/* 515:    */   {
/* 516:541 */     return getServer().getPluginManager().getPlugins();
/* 517:    */   }
/* 518:    */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.Main
 * JD-Core Version:    0.7.0.1
 */