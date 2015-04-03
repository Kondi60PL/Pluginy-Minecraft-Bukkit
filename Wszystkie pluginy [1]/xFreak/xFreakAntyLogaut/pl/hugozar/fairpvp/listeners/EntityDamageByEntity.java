package pl.hugozar.fairpvp.listeners;

import org.bukkit.event.entity.*;
import org.bukkit.*;
import pl.hugozar.fairpvp.*;
import me.confuser.barapi.*;
import pl.hugozar.fairpvp.managers.*;
import org.bukkit.entity.*;
import org.bukkit.projectiles.*;
import org.bukkit.event.*;

public class EntityDamageByEntity implements Listener
{
    @EventHandler
    public void onDamage(final EntityDamageByEntityEvent e) {
        final Entity entity = e.getEntity();
        final Entity damager = e.getDamager();
        if (damager instanceof Projectile) {
            final ProjectileSource oDamager = ((Projectile)damager).getShooter();
            if (entity instanceof Player && oDamager instanceof Player) {
                final Player pEntity = (Player)entity;
                final Player pDamager = (Player)oDamager;
                if (pEntity != pDamager) {
                    if (pDamager.getGameMode().equals((Object)GameMode.CREATIVE)) {
                        e.setCancelled(true);
                        pDamager.sendMessage(Utils.fixColors(FairPvP.getInst().getConfig().getString("BlockGameModeDamage")));
                    }
                    else if (pDamager.isFlying()) {
                        e.setCancelled(true);
                        pDamager.sendMessage(Utils.fixColors(FairPvP.getInst().getConfig().getString("BlockFlyDamage")));
                    }
                    else {
                        BarAPI.setMessage(pEntity, Utils.fixColors("&cANTY-LOGOUT"));
                        PvPManager.setLastDamager(pEntity, (Entity)pDamager);
                        PvPManager.setPvPTime(pEntity, 200);
                        BarAPI.setMessage(pDamager, Utils.fixColors("&cANTY-LOGOUT"));
                        PvPManager.setLastDamager(pDamager, entity);
                        PvPManager.setPvPTime(pDamager, 200);
                    }
                }
            }
            else {
                if (entity instanceof Player) {
                    final Player pEntity = (Player)entity;
                    BarAPI.setMessage(pEntity, Utils.fixColors("&cANTY-LOGOUT"));
                    PvPManager.setLastDamager(pEntity, damager);
                    PvPManager.setPvPTime(pEntity, 200);
                }
                if (oDamager instanceof Player) {
                    final Player pDamager2 = (Player)oDamager;
                    BarAPI.setMessage(pDamager2, Utils.fixColors("&cANTY-LOGOUT"));
                    PvPManager.setLastDamager(pDamager2, entity);
                    PvPManager.setPvPTime(pDamager2, 200);
                }
            }
        }
        else if (entity instanceof Player && damager instanceof Player) {
            final Player pEntity2 = (Player)entity;
            final Player pDamager2 = (Player)damager;
            if (pDamager2.getGameMode().equals((Object)GameMode.CREATIVE)) {
                e.setCancelled(true);
                pDamager2.sendMessage(Utils.fixColors(FairPvP.getInst().getConfig().getString("BlockGameModeDamage")));
            }
            else if (pDamager2.isFlying()) {
                e.setCancelled(true);
                pDamager2.sendMessage(Utils.fixColors(FairPvP.getInst().getConfig().getString("BlockFlyDamage")));
            }
            else {
                BarAPI.setMessage(pEntity2, Utils.fixColors("&cANTY-LOGOUT"));
                PvPManager.setLastDamager(pEntity2, damager);
                PvPManager.setPvPTime(pEntity2, 200);
                BarAPI.setMessage(pDamager2, Utils.fixColors("&cANTY-LOGOUT"));
                PvPManager.setLastDamager(pDamager2, entity);
                PvPManager.setPvPTime(pDamager2, 200);
            }
        }
        else {
            if (entity instanceof Player) {
                final Player pEntity2 = (Player)entity;
                BarAPI.setMessage(pEntity2, Utils.fixColors("&cANTY-LOGOUT"));
                PvPManager.setLastDamager(pEntity2, damager);
                PvPManager.setPvPTime(pEntity2, 200);
            }
            if (damager instanceof Player) {
                final Player pDamager3 = (Player)damager;
                BarAPI.setMessage(pDamager3, Utils.fixColors("&cANTY-LOGOUT"));
                PvPManager.setLastDamager(pDamager3, entity);
                PvPManager.setPvPTime(pDamager3, 200);
            }
        }
    }
}
