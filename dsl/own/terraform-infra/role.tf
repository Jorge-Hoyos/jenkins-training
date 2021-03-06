terraform {
  required_providers {
    aws = {
      source = "hashicorp/aws"
    }
  }
}

provider "aws" {
  profile = "default"
  region  = var.region
}


resource "aws_iam_role" "jenkins_role" {
  assume_role_policy = data.aws_iam_policy_document.jenkins_assume_role_policy.json
  name               = "jenkins-role"
  path               = "/jenkins/"
}

data "aws_iam_policy_document" "jenkins_assume_role_policy" {
  statement {
    actions = ["sts:AssumeRole"]
    principals {
      type        = "Service"
      identifiers = ["ec2.amazonaws.com"]
    }
  }
}
