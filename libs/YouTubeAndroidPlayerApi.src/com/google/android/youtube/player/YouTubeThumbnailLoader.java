package com.google.android.youtube.player;

public abstract interface YouTubeThumbnailLoader
{
  public abstract void setOnThumbnailLoadedListener(OnThumbnailLoadedListener paramOnThumbnailLoadedListener);
  
  public abstract void setVideo(String paramString);
  
  public abstract void setPlaylist(String paramString);
  
  public abstract void setPlaylist(String paramString, int paramInt);
  
  public abstract void next();
  
  public abstract void previous();
  
  public abstract void first();
  
  public abstract boolean hasNext();
  
  public abstract boolean hasPrevious();
  
  public abstract void release();
  
  public static enum ErrorReason
  {
    private ErrorReason() {}
  }
  
  public static abstract interface OnThumbnailLoadedListener
  {
    public abstract void onThumbnailLoaded(YouTubeThumbnailView paramYouTubeThumbnailView, String paramString);
    
    public abstract void onThumbnailError(YouTubeThumbnailView paramYouTubeThumbnailView, YouTubeThumbnailLoader.ErrorReason paramErrorReason);
  }
}


/* Location:           E:\Android\Workspace\HelwanSBV2\libs\YouTubeAndroidPlayerApi.jar
 * Qualified Name:     com.google.android.youtube.player.YouTubeThumbnailLoader
 * JD-Core Version:    0.7.0.1
 */