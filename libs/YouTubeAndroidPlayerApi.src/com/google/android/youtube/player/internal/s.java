package com.google.android.youtube.player.internal;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.KeyEvent;
import android.view.View;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.ErrorReason;
import com.google.android.youtube.player.YouTubePlayer.OnFullscreenListener;
import com.google.android.youtube.player.YouTubePlayer.PlaybackEventListener;
import com.google.android.youtube.player.YouTubePlayer.PlayerStateChangeListener;
import com.google.android.youtube.player.YouTubePlayer.PlayerStyle;
import com.google.android.youtube.player.YouTubePlayer.PlaylistEventListener;
import java.util.List;

public final class s
  implements YouTubePlayer
{
  private b a;
  private d b;
  
  public s(b paramb, d paramd)
  {
    this.a = ((b)ac.a(paramb, "connectionClient cannot be null"));
    this.b = ((d)ac.a(paramd, "embeddedPlayer cannot be null"));
  }
  
  public final void a(boolean paramBoolean)
  {
    try
    {
      this.b.a(paramBoolean);
      this.a.a(paramBoolean);
    }
    catch (RemoteException paramBoolean)
    {
      throw new q(paramBoolean);
    }
    this.a.d();
  }
  
  public final void cueVideo(String paramString)
  {
    cueVideo(paramString, 0);
  }
  
  public final void loadVideo(String paramString)
  {
    loadVideo(paramString, 0);
  }
  
  public final void cuePlaylist(String paramString)
  {
    cuePlaylist(paramString, 0, 0);
  }
  
  public final void loadPlaylist(String paramString)
  {
    loadPlaylist(paramString, 0, 0);
  }
  
  public final void cueVideos(List<String> paramList)
  {
    cueVideos(paramList, 0, 0);
  }
  
  public final void loadVideos(List<String> paramList)
  {
    loadVideos(paramList, 0, 0);
  }
  
  public final View a()
  {
    try
    {
      return (View)v.a(this.b.s());
    }
    catch (RemoteException localRemoteException)
    {
      throw new q(localRemoteException);
    }
  }
  
  public final void b()
  {
    try
    {
      this.b.m();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new q(localRemoteException);
    }
  }
  
  public final void c()
  {
    try
    {
      this.b.n();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new q(localRemoteException);
    }
  }
  
  public final void d()
  {
    try
    {
      this.b.o();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new q(localRemoteException);
    }
  }
  
  public final void e()
  {
    try
    {
      this.b.p();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new q(localRemoteException);
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    try
    {
      this.b.e(paramBoolean);
      return;
    }
    catch (RemoteException paramBoolean)
    {
      throw new q(paramBoolean);
    }
  }
  
  public final void a(Configuration paramConfiguration)
  {
    try
    {
      this.b.a(paramConfiguration);
      return;
    }
    catch (RemoteException paramConfiguration)
    {
      throw new q(paramConfiguration);
    }
  }
  
  public final void f()
  {
    try
    {
      this.b.q();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new q(localRemoteException);
    }
  }
  
  public final void g()
  {
    try
    {
      this.b.l();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new q(localRemoteException);
    }
  }
  
  public final boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    try
    {
      return this.b.a(paramInt, paramKeyEvent);
    }
    catch (RemoteException paramInt)
    {
      throw new q(paramInt);
    }
  }
  
  public final boolean b(int paramInt, KeyEvent paramKeyEvent)
  {
    try
    {
      return this.b.b(paramInt, paramKeyEvent);
    }
    catch (RemoteException paramInt)
    {
      throw new q(paramInt);
    }
  }
  
  public final Bundle h()
  {
    try
    {
      return this.b.r();
    }
    catch (RemoteException localRemoteException)
    {
      throw new q(localRemoteException);
    }
  }
  
  public final boolean a(Bundle paramBundle)
  {
    try
    {
      return this.b.a(paramBundle);
    }
    catch (RemoteException paramBundle)
    {
      throw new q(paramBundle);
    }
  }
  
  public final void release()
  {
    a(true);
  }
  
  public final void cueVideo(String paramString, int paramInt)
  {
    try
    {
      this.b.a(paramString, paramInt);
      return;
    }
    catch (RemoteException paramString)
    {
      throw new q(paramString);
    }
  }
  
  public final void loadVideo(String paramString, int paramInt)
  {
    try
    {
      this.b.b(paramString, paramInt);
      return;
    }
    catch (RemoteException paramString)
    {
      throw new q(paramString);
    }
  }
  
  public final void cuePlaylist(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      this.b.a(paramString, paramInt1, paramInt2);
      return;
    }
    catch (RemoteException paramString)
    {
      throw new q(paramString);
    }
  }
  
  public final void loadPlaylist(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      this.b.b(paramString, paramInt1, paramInt2);
      return;
    }
    catch (RemoteException paramString)
    {
      throw new q(paramString);
    }
  }
  
  public final void cueVideos(List<String> paramList, int paramInt1, int paramInt2)
  {
    try
    {
      this.b.a(paramList, paramInt1, paramInt2);
      return;
    }
    catch (RemoteException paramList)
    {
      throw new q(paramList);
    }
  }
  
  public final void loadVideos(List<String> paramList, int paramInt1, int paramInt2)
  {
    try
    {
      this.b.b(paramList, paramInt1, paramInt2);
      return;
    }
    catch (RemoteException paramList)
    {
      throw new q(paramList);
    }
  }
  
  public final void play()
  {
    try
    {
      this.b.a();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new q(localRemoteException);
    }
  }
  
  public final void pause()
  {
    try
    {
      this.b.b();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new q(localRemoteException);
    }
  }
  
  public final boolean isPlaying()
  {
    try
    {
      return this.b.c();
    }
    catch (RemoteException localRemoteException)
    {
      throw new q(localRemoteException);
    }
  }
  
  public final boolean hasNext()
  {
    try
    {
      return this.b.d();
    }
    catch (RemoteException localRemoteException)
    {
      throw new q(localRemoteException);
    }
  }
  
  public final boolean hasPrevious()
  {
    try
    {
      return this.b.e();
    }
    catch (RemoteException localRemoteException)
    {
      throw new q(localRemoteException);
    }
  }
  
  public final void next()
  {
    try
    {
      this.b.f();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new q(localRemoteException);
    }
  }
  
  public final void previous()
  {
    try
    {
      this.b.g();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new q(localRemoteException);
    }
  }
  
  public final int getCurrentTimeMillis()
  {
    try
    {
      return this.b.h();
    }
    catch (RemoteException localRemoteException)
    {
      throw new q(localRemoteException);
    }
  }
  
  public final int getDurationMillis()
  {
    try
    {
      return this.b.i();
    }
    catch (RemoteException localRemoteException)
    {
      throw new q(localRemoteException);
    }
  }
  
  public final void seekToMillis(int paramInt)
  {
    try
    {
      this.b.a(paramInt);
      return;
    }
    catch (RemoteException paramInt)
    {
      throw new q(paramInt);
    }
  }
  
  public final void seekRelativeMillis(int paramInt)
  {
    try
    {
      this.b.b(paramInt);
      return;
    }
    catch (RemoteException paramInt)
    {
      throw new q(paramInt);
    }
  }
  
  public final void setFullscreen(boolean paramBoolean)
  {
    try
    {
      this.b.b(paramBoolean);
      return;
    }
    catch (RemoteException paramBoolean)
    {
      throw new q(paramBoolean);
    }
  }
  
  public final void setFullscreenControlFlags(int paramInt)
  {
    try
    {
      this.b.c(paramInt);
      return;
    }
    catch (RemoteException paramInt)
    {
      throw new q(paramInt);
    }
  }
  
  public final int getFullscreenControlFlags()
  {
    try
    {
      return this.b.j();
    }
    catch (RemoteException localRemoteException)
    {
      throw new q(localRemoteException);
    }
  }
  
  public final void addFullscreenControlFlag(int paramInt)
  {
    try
    {
      this.b.d(paramInt);
      return;
    }
    catch (RemoteException paramInt)
    {
      throw new q(paramInt);
    }
  }
  
  public final void setPlayerStyle(YouTubePlayer.PlayerStyle paramPlayerStyle)
  {
    try
    {
      this.b.a(paramPlayerStyle.name());
      return;
    }
    catch (RemoteException paramPlayerStyle)
    {
      throw new q(paramPlayerStyle);
    }
  }
  
  public final void setShowFullscreenButton(boolean paramBoolean)
  {
    try
    {
      this.b.c(paramBoolean);
      return;
    }
    catch (RemoteException paramBoolean)
    {
      throw new q(paramBoolean);
    }
  }
  
  public final void setManageAudioFocus(boolean paramBoolean)
  {
    try
    {
      this.b.d(paramBoolean);
      return;
    }
    catch (RemoteException paramBoolean)
    {
      throw new q(paramBoolean);
    }
  }
  
  public final void setOnFullscreenListener(final YouTubePlayer.OnFullscreenListener paramOnFullscreenListener)
  {
    try
    {
      this.b.a(new e.a()
      {
        public final void a(boolean paramAnonymousBoolean)
        {
          paramOnFullscreenListener.onFullscreen(paramAnonymousBoolean);
        }
      });
      return;
    }
    catch (RemoteException paramOnFullscreenListener)
    {
      throw new q(paramOnFullscreenListener);
    }
  }
  
  public final void setPlaylistEventListener(final YouTubePlayer.PlaylistEventListener paramPlaylistEventListener)
  {
    try
    {
      this.b.a(new h.a()
      {
        public final void a()
        {
          paramPlaylistEventListener.onPrevious();
        }
        
        public final void c()
        {
          paramPlaylistEventListener.onPlaylistEnded();
        }
        
        public final void b()
        {
          paramPlaylistEventListener.onNext();
        }
      });
      return;
    }
    catch (RemoteException paramPlaylistEventListener)
    {
      throw new q(paramPlaylistEventListener);
    }
  }
  
  public final void setPlayerStateChangeListener(final YouTubePlayer.PlayerStateChangeListener paramPlayerStateChangeListener)
  {
    try
    {
      this.b.a(new g.a()
      {
        public final void c()
        {
          paramPlayerStateChangeListener.onVideoStarted();
        }
        
        public final void d()
        {
          paramPlayerStateChangeListener.onVideoEnded();
        }
        
        public final void a()
        {
          paramPlayerStateChangeListener.onLoading();
        }
        
        public final void a(String paramAnonymousString)
        {
          paramPlayerStateChangeListener.onLoaded(paramAnonymousString);
        }
        
        public final void b(String paramAnonymousString)
        {
          try
          {
            paramAnonymousString = YouTubePlayer.ErrorReason.valueOf(paramAnonymousString);
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            paramAnonymousString = YouTubePlayer.ErrorReason.UNKNOWN;
          }
          catch (NullPointerException localNullPointerException)
          {
            paramAnonymousString = YouTubePlayer.ErrorReason.UNKNOWN;
          }
          paramPlayerStateChangeListener.onError(paramAnonymousString);
        }
        
        public final void b()
        {
          paramPlayerStateChangeListener.onAdStarted();
        }
      });
      return;
    }
    catch (RemoteException paramPlayerStateChangeListener)
    {
      throw new q(paramPlayerStateChangeListener);
    }
  }
  
  public final void setPlaybackEventListener(final YouTubePlayer.PlaybackEventListener paramPlaybackEventListener)
  {
    try
    {
      this.b.a(new f.a()
      {
        public final void c()
        {
          paramPlaybackEventListener.onStopped();
        }
        
        public final void a(int paramAnonymousInt)
        {
          paramPlaybackEventListener.onSeekTo(paramAnonymousInt);
        }
        
        public final void a()
        {
          paramPlaybackEventListener.onPlaying();
        }
        
        public final void b()
        {
          paramPlaybackEventListener.onPaused();
        }
        
        public final void a(boolean paramAnonymousBoolean)
        {
          paramPlaybackEventListener.onBuffering(paramAnonymousBoolean);
        }
      });
      return;
    }
    catch (RemoteException paramPlaybackEventListener)
    {
      throw new q(paramPlaybackEventListener);
    }
  }
}


/* Location:           E:\Android\Workspace\HelwanSBV2\libs\YouTubeAndroidPlayerApi.jar
 * Qualified Name:     com.google.android.youtube.player.internal.s
 * JD-Core Version:    0.7.0.1
 */