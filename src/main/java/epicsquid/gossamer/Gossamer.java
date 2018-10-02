package epicsquid.gossamer;

import epicsquid.gossamer.proxy.CommonProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Gossamer.MODID, version = Gossamer.VERSION, name = Gossamer.NAME)
public class Gossamer {
  public static final String MODID = "gossamer-3";
  public static final String DOMAIN = "gossamer";
  public static final String NAME = "Gossamer";
  public static final String VERSION = "@VERSION@";

  public static ModContainer CONTAINER = null;

  @SidedProxy(clientSide = "epicsquid.gossamer.proxy.ClientProxy", serverSide = "epicsquid.gossamer.proxy.CommonProxy")
  public static CommonProxy proxy;

  @Instance(MODID) public static Gossamer instance;

//  public static CreativeTabs tab = new CreativeTabs("gossamer") {
//    @Override
//    public String getTabLabel() {
//      return "gossamer";
//    }
//
//    @Override
//    @SideOnly(Side.CLIENT)
//    public ItemStack getTabIconItem() {
//      return new ItemStack(ModItems.carapace, 1);
//    }
//  };

  @EventHandler
  public void preInit(FMLPreInitializationEvent event) {
    CONTAINER = Loader.instance().activeModContainer();
    MinecraftForge.EVENT_BUS.register(new RegistryManager());
    proxy.preInit(event);
  }

  public static Gossamer getInstance() {
    return instance;
  }

  @EventHandler
  public void init(FMLInitializationEvent event) {
    proxy.init(event);
  }

  @EventHandler
  public void postInit(FMLPostInitializationEvent event) {
    proxy.postInit(event);
  }
}
