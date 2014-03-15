package com.google.android.youtube.player.internal;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class aa
  extends y
{
  private static final Class<?>[] a = { Context.class, AttributeSet.class };
  private final Resources b;
  private final LayoutInflater c;
  private final Resources.Theme d;
  
  public aa(Activity paramActivity, Resources paramResources, ClassLoader paramClassLoader, int paramInt)
  {
    super(paramActivity);
    this.b = ((Resources)ac.a(paramResources, "resources cannot be null"));
    paramActivity = this;
    (paramActivity = ((LayoutInflater)super.getSystemService("layout_inflater")).cloneInContext(paramActivity)).setFactory(new a(paramClassLoader));
    this.c = paramActivity;
    this.d = paramResources.newTheme();
    this.d.applyStyle(paramInt, false);
  }
  
  public final Resources getResources()
  {
    return this.b;
  }
  
  public final Object getSystemService(String paramString)
  {
    if ("layout_inflater".equals(paramString)) {
      return this.c;
    }
    return super.getSystemService(paramString);
  }
  
  public final Resources.Theme getTheme()
  {
    return this.d;
  }
  
  public final Context getApplicationContext()
  {
    return super.getApplicationContext();
  }
  
  public final Context getBaseContext()
  {
    return super.getBaseContext();
  }
  
  private static final class a
    implements LayoutInflater.Factory
  {
    private final ClassLoader a;
    
    public a(ClassLoader paramClassLoader)
    {
      this.a = ((ClassLoader)ac.a(paramClassLoader, "remoteClassLoader cannot be null"));
    }
    
    public final View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
    {
      try
      {
        return (View)this.a.loadClass(paramString).asSubclass(View.class).getConstructor(aa.a()).newInstance(new Object[] { paramContext, paramAttributeSet });
      }
      catch (NoClassDefFoundError localNoClassDefFoundError)
      {
        return null;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        return null;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        return null;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        return null;
      }
      catch (InstantiationException localInstantiationException)
      {
        return null;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        return null;
      }
      catch (InvocationTargetException localInvocationTargetException) {}
      return null;
    }
  }
}


/* Location:           E:\Android\Workspace\HelwanSBV2\libs\YouTubeAndroidPlayerApi.jar
 * Qualified Name:     com.google.android.youtube.player.internal.aa
 * JD-Core Version:    0.7.0.1
 */