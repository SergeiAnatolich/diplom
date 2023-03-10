// Generated by view binder compiler. Do not edit!
package ru.iteco.fmhandroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import ru.iteco.fmhandroid.R;

public final class ItemCommentBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView commentDateTextView;

  @NonNull
  public final TextView commentDescriptionTextView;

  @NonNull
  public final TextView commentTimeTextView;

  @NonNull
  public final TextView commentatorNameTextView;

  @NonNull
  public final ImageButton editCommentImageButton;

  private ItemCommentBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView commentDateTextView, @NonNull TextView commentDescriptionTextView,
      @NonNull TextView commentTimeTextView, @NonNull TextView commentatorNameTextView,
      @NonNull ImageButton editCommentImageButton) {
    this.rootView = rootView;
    this.commentDateTextView = commentDateTextView;
    this.commentDescriptionTextView = commentDescriptionTextView;
    this.commentTimeTextView = commentTimeTextView;
    this.commentatorNameTextView = commentatorNameTextView;
    this.editCommentImageButton = editCommentImageButton;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemCommentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemCommentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_comment, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemCommentBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.comment_date_text_view;
      TextView commentDateTextView = ViewBindings.findChildViewById(rootView, id);
      if (commentDateTextView == null) {
        break missingId;
      }

      id = R.id.comment_description_text_view;
      TextView commentDescriptionTextView = ViewBindings.findChildViewById(rootView, id);
      if (commentDescriptionTextView == null) {
        break missingId;
      }

      id = R.id.comment_time_text_view;
      TextView commentTimeTextView = ViewBindings.findChildViewById(rootView, id);
      if (commentTimeTextView == null) {
        break missingId;
      }

      id = R.id.commentator_name_text_view;
      TextView commentatorNameTextView = ViewBindings.findChildViewById(rootView, id);
      if (commentatorNameTextView == null) {
        break missingId;
      }

      id = R.id.edit_comment_image_button;
      ImageButton editCommentImageButton = ViewBindings.findChildViewById(rootView, id);
      if (editCommentImageButton == null) {
        break missingId;
      }

      return new ItemCommentBinding((ConstraintLayout) rootView, commentDateTextView,
          commentDescriptionTextView, commentTimeTextView, commentatorNameTextView,
          editCommentImageButton);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
