package com.google.android.youtube.player;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.youtube.player.internal.ac;

public class YouTubePlayerSupportFragment
  extends Fragment
  implements YouTubePlayer.Provider
{
  private final a a = new a((byte)0);
  private Bundle b;
  private YouTubePlayerView c;
  private String d;
  private YouTubePlayer.OnInitializedListener e;
  
  public static YouTubePlayerSupportFragment newInstance()
  {
    return new YouTubePlayerSupportFragment();
  }
  
  public void initialize(String paramString, YouTubePlayer.OnInitializedListener paramOnInitializedListener)
  {
    this.d = ac.a(paramString, "Developer key cannot be null or empty");
    this.e = paramOnInitializedListener;
    a();
  }
  
  private void a()
  {
    if ((this.c != null) && (this.e != null))
    {
      this.c.a(getActivity(), this, this.d, this.e, this.b);
      this.b = null;
      this.e = null;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.b = (paramBundle != null ? paramBundle.getBundle("YouTubePlayerSupportFragment.KEY_PLAYER_VIEW_STATE") : null);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.c = new YouTubePlayerView(getActivity(), null, 0, this.a);
    a();
    return this.c;
  }
  
  public void onStart()
  {
    super.onStart();
    this.c.a();
  }
  
  public void onResume()
  {
    super.onResume();
    this.c.b();
  }
  
  public void onPause()
  {
    this.c.c();
    super.onPause();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    Bundle localBundle = this.c != null ? this.c.e() : this.b;
    paramBundle.putBundle("YouTubePlayerSupportFragment.KEY_PLAYER_VIEW_STATE", localBundle);
  }
  
  public void onStop()
  {
    this.c.d();
    super.onStop();
  }
  
  public void onDestroyView()
  {
    this.c.b(getActivity().isFinishing());
    this.c = null;
    super.onDestroyView();
  }
  
  public void onDestroy()
  {
    if (this.c != null)
    {
      FragmentActivity localFragmentActivity = getActivity();
      this.c.a((localFragmentActivity == null) || (localFragmentActivity.isFinishing()));
    }
    super.onDestroy();
  }
  
  private final class a
    implements YouTubePlayerView.b
  {
    private a() {}
    
    public final void a(YouTubePlayerView paramYouTubePlayerView, String paramString, YouTubePlayer.OnInitializedListener paramOnInitializedListener)
    {
      YouTubePlayerSupportFragment.this.initialize(paramString, YouTubePlayerSupportFragment.a(YouTubePlayerSupportFragment.this));
    }
    
    public final void a(YouTubePlayerView paramYouTubePlayerView) {}
  }
}


/* Location:           E:\Android\Workspace\HelwanSBV2\libs\YouTubeAndroidPlayerApi.jar
 * Qualified Name:     com.google.android.youtube.player.YouTubePlayerSupportFragment
 * JD-Core Version:    0.7.0.1
 */