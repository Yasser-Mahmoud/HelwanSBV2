package com.google.android.youtube.player.internal;

import java.lang.reflect.Field;

public final class v<T>
  extends u.a
{
  private final T a;
  
  private v(T paramT)
  {
    this.a = paramT;
  }
  
  public static <T> u a(T paramT)
  {
    return new v(paramT);
  }
  
  public static <T> T a(u paramu)
  {
    if ((paramu instanceof v)) {
      return ((v)paramu).a;
    }
    Object localObject;
    if ((localObject = (paramu = paramu.asBinder()).getClass().getDeclaredFields()).length == 1)
    {
      if (!(localObject = localObject[0]).isAccessible())
      {
        ((Field)localObject).setAccessible(true);
        try
        {
          return ((Field)localObject).get(paramu);
        }
        catch (NullPointerException paramu)
        {
          throw new IllegalArgumentException("Binder object is null.", paramu);
        }
        catch (IllegalArgumentException paramu)
        {
          throw new IllegalArgumentException("remoteBinder is the wrong class.", paramu);
        }
        catch (IllegalAccessException paramu)
        {
          throw new IllegalArgumentException("Could not access the field in remoteBinder.", paramu);
        }
      }
      throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
    }
    throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
  }
}


/* Location:           E:\Android\Workspace\HelwanSBV2\libs\YouTubeAndroidPlayerApi.jar
 * Qualified Name:     com.google.android.youtube.player.internal.v
 * JD-Core Version:    0.7.0.1
 */